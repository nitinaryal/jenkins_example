Jenkins pipepline

1. Create Jenkinsfile
2. Jenkinsfile start with pipeline {} block e.g.

   pipeline {

   }

3. Specify which agent will be use to run the pipeline. This is useful when you have multiple jenkins build servers (nodes) setup and you want to specific one to use. For example , if you are fine with any one agent then you can simply specify "any" as shown below

   pipeline {
    agent: any

   }

4. Then we have to define stages which is a block that define what will be done or executed. 
   Note: you can define multiple stage within stages block. Each stage block then can have multiple steps which will execute given instruction (e.g. scripts)

pipeline {
    agent any
    stages {
        stage ("Clean up"){
            steps{
                //Recursively delete the current directory from the workspace 
                //Ref: https://www.jenkins.io/doc/pipeline/steps/workflow-basic-steps/#deletedir-recursively-delete-the-current-directory-from-the-workspace
                deleteDir() 
            } 
        }
        stage("Clone Repo"){
            steps{
                //The following command will clone the given repo and create directory "jenkins_example" under current workspace
                sh "git clone https://github.com/nitinaryal/jenkins_example"
            }
        }
        stage("Build"){
            steps {
                //dir() step will change current working directory to directory specified as param e.g. in this case "jenkins_example"
                dir("jenkins_example"){
                    //Executing maven clean build command
                    sh "mvn clean install"
                }
            }
        }
        stage("Test"){
            steps{
                dir("jenkins_example"){
                    //Executing maven clean build command
                    sh "mvn test"
                }
            }
        }
    }
}

