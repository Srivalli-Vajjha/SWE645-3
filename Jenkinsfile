pipeline{
    
    environment {
        registry = "srivallivajha/surveyjar"
        registryCredential = 'dockerhub'
        def dateTag = new Date().format("yyyyMMdd-HHmmss")
	}
agent any
    tools{
        maven 'Maven 3.8.6'
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
     stage('Build Docker Image and Push'){
        steps{
            script {
                  docker.withRegistry('',registryCredential) {
                        def image = docker.build('srivallivajha/surveyjar:'+ dateTag, '. --no-cache')
                        docker.withRegistry('',registryCredential) {
                            image.push()
                        }
                    }
            }
        }
     }
      stage('Deploying to single node in Rancher'){
        steps{
            script {
                  sh 'kubectl set image deployment/deploy1 container-0=srivallivajha/surveyjar:'+dateTag
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
