pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "Maven"
    }
    
    environment
    {
        registry = "av2000/scientific-calculator"
        registryCredential = "b4d47305-d146-4d50-b207-673d642e44f9"
        dockerImage = ""
    }

    stages {
        stage('Git pull') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/vardhan2000/scientificCalculator.git'
            }
        }
        stage('Build') {
            steps {
                // Run Maven on a Unix agent.
                sh "mvn clean install"
            }
        }
        
        stage('build docker image') {
            steps {
                script {
                    dockerImage = docker.build(registry + ":latest")
                }
            }
        }
        
        stage('DockerHub Image Push') {
            steps {
                script {
                    docker.withRegistry('', registryCredential) {
                        dockerImage.push()
                    }
                }
            }
        }
        
        stage('Clean Up') {
            steps {
                sh "docker rmi $registry:latest" 
            }
        } 
    }
}
