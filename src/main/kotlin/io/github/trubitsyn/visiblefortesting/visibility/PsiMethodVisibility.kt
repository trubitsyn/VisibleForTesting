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

package io.github.trubitsyn.visiblefortesting.visibility

import com.intellij.psi.PsiMethod
import com.intellij.psi.PsiModifier

class PsiMethodVisibility(val method: PsiMethod) : Visibility {
    override val isProtected: Boolean
        get() = method.hasModifierProperty(PsiModifier.PROTECTED)
    override val isPackageLocal: Boolean
        get() = method.hasModifierProperty(PsiModifier.PACKAGE_LOCAL)
    override val isPrivate: Boolean
        get() = method.hasModifierProperty(PsiModifier.PRIVATE)
}