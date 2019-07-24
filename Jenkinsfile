pipeline {
    agent any
    environment {
        DOCKER_USER = 'arturo-gutierrez@live.com'
        DOCKER_PASSWORD = 'gusa840419bc7'
    }
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
                publishHTML (
                    target: [
                        reportDir: "build/reports/jacoco/test/html",
                        reportFiles: "index.html",
                        reportName: "JaCoCo Report"
                    ]
                )
                sh "./gradlew jacocoTestCoverageVerification"
            }
        }
        stage("Static Code Analysis"){
            steps{
                sh "./gradlew checkstyleMain"
                                publishHTML (
                    target: [
                        reportDir: "build/reports/checkstyle/",
                        reportFiles: "main.html",
                        reportName: "Checkstyle Report"
                    ]
                )
            }
        }
        stage("Package"){
            steps {
                sh "./gradlew build"
            }
        }
        stage("Docker Build"){
            steps {
                sh "docker build -t a00783576/calculator ."
            }
        }
        stage("Docker Push"){
            steps {
                sh "docker login --username $DOCKER_USER --password $DOCKER_PASSWORD"
                sh "docker push a00783576/calculator"
            }
        }
    }

    post {
        success {
            slackSend channel: "#builds", 
                color: "good", 
                message: "*${currentBuild.currentResult}:* Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}"
        }
        unstable {
            slackSend channel: "#builds", 
                color: "danger", 
                message: "*${currentBuild.currentResult}:* Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}"
        }
        failure {
            slackSend channel: "#builds", 
                color: "danger", 
                message: "*${currentBuild.currentResult}:* Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}"
        }
        changed {
            slackSend channel: "#builds", 
                color: "danger", 
                message: "*${currentBuild.currentResult}:* Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}"
        }
    }
}
