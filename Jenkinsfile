//This file with create a CI/CD pipeline for building and deploying the dcoker image to k8 cluster using Github as source control version.

pipeline{
    
    environment {
        registryCredential = 'dockerhub'
        def dateTag = new Date().format("yyyyMMdd-HHmmss")
	}
agent any
    tools{
        maven 'Maven 3.6.3'
    }
  stages{
     stage('Maven clean & Install'){
        steps{
            script{
                sh 'mvn clean'
                sh 'mvn install'
            }
        }
     }
     stage('Build Docker Image'){
        steps{
            script {
                docker.withRegistry('',registryCredential){
                    def image = docker.build("srivallivajha/surveyjar:${env.dateTag}")
                }
            }
        }
     }
     }
 
  post {
	  always {
			sh 'docker logout'
		}
	}    
}
