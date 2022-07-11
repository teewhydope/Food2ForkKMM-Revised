object Build {
    private const val gradleBuildTools = "7.1.3"
    const val buildTools = "com.android.tools.build:gradle:$gradleBuildTools"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"
    const val sqlDelightGradlePlugin =
        "com.squareup.sqldelight:gradle-plugin:${SQLDelight.sqlDelightVersion}"
    const val remalGradlePlugin = "name.remal:gradle-plugins:${RemalDependencyCheck.version}"

    private const val mokoGradleVersion = "0.5.0"
    const val mokoKSwiftGradlePlugin = "dev.icerock.moko:kswift-gradle-plugin:$mokoGradleVersion"
}
