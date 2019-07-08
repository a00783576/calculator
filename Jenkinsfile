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
    }

    post {
        always {	              
              if ( currentBuild.currentResult == "SUCCESS" ) {
                    slackSend color: "good", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was successful"
                }
                else if( currentBuild.currentResult == "FAILURE" ) { 
                    slackSend color: "danger", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was failed"
                }
                else if( currentBuild.currentResult == "UNSTABLE" ) { 
                    slackSend color: "warning", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was unstable"
                }
                else {
                    slackSend color: "danger", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} its resulat was unclear"	
                }
            cleanWs()
        }
    }
}
