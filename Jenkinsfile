pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "Maven"
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
                sh "mvn clean package"
            }
        }    
    }
}
