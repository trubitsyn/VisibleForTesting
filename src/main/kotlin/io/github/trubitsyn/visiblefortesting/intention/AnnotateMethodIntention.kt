/*
 * Copyright 2017 Nikola Trubitsyn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.trubitsyn.visiblefortesting.intention

import com.intellij.codeInsight.CodeInsightBundle
import com.intellij.codeInsight.intention.BaseElementAtCaretIntentionAction
import com.intellij.ide.projectView.impl.ProjectRootsUtil
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiJavaToken
import com.intellij.psi.PsiMethod
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.IncorrectOperationException
import io.github.trubitsyn.visiblefortesting.annotable.PsiAnnotableUtil
import io.github.trubitsyn.visiblefortesting.annotation.Annotations
import io.github.trubitsyn.visiblefortesting.annotation.base.Annotation
import io.github.trubitsyn.visiblefortesting.ui.ChooseAnnotationPopup
import org.jetbrains.annotations.NonNls

class AnnotateMethodIntention : BaseElementAtCaretIntentionAction() {
    var availableAnnotations: List<Annotation> = emptyList()

    @NonNls
    override fun getText() = "Annotate as @VisibleForTesting"

    @NonNls
    override fun getFamilyName() = CodeInsightBundle.message("intention.add.annotation.family")

    override fun isAvailable(project: Project, editor: Editor, psiElement: PsiElement): Boolean {
        if (ProjectRootsUtil.isInTestSource(psiElement.containingFile)) {
            return false
        }

        if (psiElement is PsiJavaToken && psiElement.parent is PsiMethod) {
            if (availableAnnotations.isEmpty()) {
                availableAnnotations = Annotations.available(project)
            }

            if (availableAnnotations.isEmpty()) {
                return false
            }

            val method = psiElement.parent as PsiMethod
            return Annotations.areApplicableTo(method, availableAnnotations)
        }
        return false
    }

    @Throws(IncorrectOperationException::class)
    override fun invoke(project: Project, editor: Editor, psiElement: PsiElement) {
        val method = PsiTreeUtil.getParentOfType(psiElement, PsiMethod::class.java, false) ?: return

        ChooseAnnotationPopup(editor).show(availableAnnotations, {
            PsiAnnotableUtil.addAnnotation(method, it)
        })
    }

    override fun startInWriteAction() = true
}
