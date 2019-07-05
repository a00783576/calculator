pipeline {
    agent any

    stages {
        stage("Compile") {
            steps {
                sh "chmod +x ./gradlew"
                sh "./gradlew compileJava"
            }
        }
        stage("Unit Test") {
            steps {
                sh "./gradlew test"
            }
        }
        stage("Code Coverage") {
            steps {
                sh "./gradlew jacocoTestReport"
                sh "./gradlew jacocoTestCoverageVerification"
            }
        }
    }
}
