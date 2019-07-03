pipeline {
    agent any

    stages {
        stage('Compile') {
            steps {
                chmod +x "./gradlew"
                sh "./gradlew compileJava"
            }
        }
        stage('Unit Test') {
            steps {
                sh "./gradlew test"
            }
        }
    }
}
