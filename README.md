# VisibleForTesting

@VisibleForTesting annotation support for the IntelliJ platform.

## Supported annotation types

* [android.support.annotation.VisibleForTesting](https://developer.android.com/reference/android/support/annotation/VisibleForTesting.html)
* [com.google.common.annotations.VisibleForTesting](https://google.github.io/guava/releases/19.0/api/docs/com/google/common/annotations/VisibleForTesting.html)

# Motivation

It's time-consuming to annotate existing non-public methods: you have to remove modifiers and manually type the annotation.

Now you don't have to: plugin will do that for you.

# Features

## Choose from multiple annotations to import

![Choose annotation](img/choose-annotation.gif)

## Annotate method

### android.support.annotation

![Annotate method](img/android/annotate-method.gif)

### com.google.common.annotations

![Annotate method](img/guava/annotate-method.gif)

## Annotate class methods

### android.support.annotation

![Annotate class methods](img/android/annotate-class-methods.gif)

### com.google.common.annotations

![Annotate class methods](img/guava/annotate-class-methods.gif)

## Annotate method from test

### android.support.annotation

![Annotate method from test](img/android/annotate-method-from-test.gif)

### com.google.common.annotations

![Annotate method from test](img/guava/annotate-method-from-test.gif)

# Prerequisites

The desired annotation type must be accessible in order for intention actions to be shown.

## android.support.annotation

Metadata is only available since Support Library 25.0.0

# Building from source

1. Clone repository
2. Run `./gradlew buildPlugin`
3. You can find the plugin in `build/distributions` directory

# LICENSE

```
Copyright 2017 Nikola Trubitsyn

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
