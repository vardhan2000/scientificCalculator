pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "Maven"
    }
    
    environment
    {
        registry = "av2000/scientific-calculator"
        registryCredential = "sciCalc dockerhub access"
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
        
        stage('Ansible pull image') {
            steps {
                ansiblePlaybook colorized: true,
                installation: 'Ansible',
                inventory: 'inventory',
                playbook: 'playbook.yml'
            }
        }
    }
}
