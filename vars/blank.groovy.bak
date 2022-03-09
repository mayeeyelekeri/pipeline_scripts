def call(body) {
  body()

  pipeline {
    	agent any 

	stages {
	  stage('Build') {
	    steps { 
		  echo "inside build"
		  echo env.DB_HOST
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

