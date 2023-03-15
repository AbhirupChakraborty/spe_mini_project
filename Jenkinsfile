pipeline {
    environment{
        imageName =""
    }
    agent any
    stages {
        stage('Git pull') {
            steps {
                git 'https://github.com/AbhirupChakraborty/spe_mini_project.git'
            }
        }
        stage('Maven Build') {
            steps {
                script{
                    sh 'mvn clean install'
                }
            }
        }
        stage('Docker Build to Image') {
            steps {
                script{
                    imageName=docker.build "abhirup18/spe_miniproj"
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script{
                    docker.withRegistry('','docker-login'){
                        imageName.push()
                    }
                }
            }
        }
        stage('Deploy') {
            steps {
                ansiblePlaybook becomeUser: null, colorized: true, disableHostKeyChecking: true, installation: 'Ansible', inventory: 'docker-deploy/inventory',
                 playbook: 'docker-deploy/playbook.yml', sudoUser: null, extras: '-e "image_name=abhirup18/spe_miniproj"'
            }
        }
    }
}
