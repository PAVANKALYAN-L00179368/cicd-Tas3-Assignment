pipeline {
    agent any
        tools{
            jdk 'jdk17'
            maven 'maven3'
        }
        environment{
            SCANNER_HOME= tool 'sonar-scanner'
        }
    stages {
        stage('Git Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/PAVANKALYAN-L00179368/cicd-Tas3-Assignment.git'
            }
        }

        stage('Compiling') {
            steps {
                bat "mvn clean compile -DskipTests=true"
            }
        }

        stage('Testing') {
            steps {
                bat "mvn test -DskipTests-true"
            }
        }

        stage('OWASP Scanner') {
            steps {
                dependencyCheck additionalArguments: '--scan ./ ',odcInstallation: 'DC'
                    dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
            }
        }

        stage('Sonarqube') {
            steps {
                withSonarQubeEnv('sonar'){
                   bat ''' $SCANNER_HOME/bin/sonar-scanner -Dsonar.projectName=Sprinboot \
                   -Dsonar.java.binaries=. \
                   -Dsonar.projectKey=Sprinboot '''
               }
            }
        }

      stage('Build') {
            steps {
                bat "mvn clean package -DskipTests=true"
            }
        }

        stage('Build and Tag Docker Image') {
            steps {
                script{
                    withDockerRegistry(credentialsId: 'docker-cred', toolName: 'docker') {
                    bat "docker build -t springbootApp:dev -f ."
                    bat "docker tag springbootApp:dev pavanvarikolu/springbootApp:dev "
                    }
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script{
                    withDockerRegistry(credentialsId: 'docker-cred', toolName: 'docker') {
                    bat "docker push pavanvarikolu/springbootApp:dev "
                    }
                }
            }
        }

        stage('Deploy in Docker') {
            steps {
                script{
                    withDockerRegistry(credentialsId: 'docker-cred', toolName: 'docker') {
                    bat "docker run -d -p 8080:8080 pavanvarikolu/springbootApp:dev "
                    }
                }
            }
        }
    }
}

