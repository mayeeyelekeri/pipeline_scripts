def call(body) {
  body()

  pipeline {
    agent any 

	environment { 
		DB_HOST = "config.DB_HOST"
	}
	
	stages {
	  stage('Build') {
	    steps { 
		  echo "inside build"
		  echo "${DB_HOST}"
		}
	  }
	  stage('deploy') {
	    steps { 
		  echo "inside deploy"
		}
	  }
	}
  }
}

