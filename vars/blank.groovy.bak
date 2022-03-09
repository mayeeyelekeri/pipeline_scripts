def call(body) {
  body()

  pipeline {
    	agent any 

	stages {
	  stage('Build') {
		echo "inside build"
	  }
	  stage('deploy') {
		echo "inside deploy"
	  }
	}
  }
}

