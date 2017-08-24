import android.support.annotation.VisibleForTesting;

class Foo {

    @VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    public void foo() {}

    @VisibleForTesting(otherwise = VisibleForTesting.PACKAGE_PRIVATE)
    public void bar() {}

    @VisibleForTesting
    public void baz() {}
}