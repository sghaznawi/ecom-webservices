pipeline {
    agent any 

    triggers {
        pollSCM('* * * * *')
    }

    stages {
        
        stage('Maven Compile') {
            steps {
                echo '----------------- Compile phase ----------'
                sh 'mvn clean compile'
            }
        }
        
         stage('Maven Test') {
            steps {
                echo '----------------- Test Phase ----------'
                sh 'mvn clean test'
            }
        }
        
        stage('Maven Build') {
             steps {
                echo '----------------- Build Phase ----------'
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                echo '----------------- Docker Build ----------'
                sh '''
                    docker image build -t ecom-webservice .
                '''
            }
        }

        stage('Docker Deploy') {
            steps {
                echo '----------------- Docker Deployment  ----------'
                sh '''
                 (if  [ $(docker ps -a | grep ecom-webservice | cut -d " " -f1) ]; then \
                        echo $(docker rm -f ecom-webservice); \
                        echo "---------------- Successfully removed ECOM-Webservice ----------------"
                     else \
                    echo OK; \
                 fi;);
            docker container run --restart always --name ecom-webservice -p 8081:8081 -d ecom-webservice
            '''
            }
        }
    }
}
