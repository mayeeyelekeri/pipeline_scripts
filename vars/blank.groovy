def call(body) {
  body()

  pipeline {
    	agent any 

	stages {
	  stage('Build') {
	    steps { 
		  echo "inside build"
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

