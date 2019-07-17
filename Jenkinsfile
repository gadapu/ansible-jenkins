pipeline {
  agent any
  tools { 
        maven 'Maven'
  }
  environment {
        EUREKA_IPADDRESS = ""
    }
  stages {
    stage('Clone repository') {
        /* Let's make sure we have the repository cloned to our workspace... */
      steps {
        checkout scm
      }
    }
    stage('Build') {
      steps {
        sh 'mvn -B -DskipTests clean package'
        sh 'echo $USER'
        sh 'echo whoami'
      }
    }
    stage('CreateInstance') {
      steps {
        ansiblePlaybook become: true, becomeUser: 'jenkins', credentialsId: 'jenkins-user', inventory: '/etc/ansible/hosts', playbook: '$WORKSPACE/createInstance.yaml'
      }
   }
   stage('DeployArtifact') {
      steps {
       ansiblePlaybook become: true, becomeUser: 'ec2-user', credentialsId: 'ec2-user', extras: '-e WORKSPACE=$WORKSPACE -e host_key_checking=no', inventory: '/tmp/hosts_eureka', playbook: '$WORKSPACE/createInstance.yaml' 
     }
     }
   }  
  }
