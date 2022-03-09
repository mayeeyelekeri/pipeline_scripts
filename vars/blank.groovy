def call(body) {
  def config = [:]
  body.resolveStrategy = Closure.DELEGATE_FIRST
  body.delegate = config 
  body()

  pipeline {
    agent any 

	environment { 
		DB_HOST = config.DB_HOST
	}
	
	stages {
	  stage('Build') {
	    steps { 
		  echo "inside build"
		  echo "${DB_HOST}"
		  echo "Global db = ${MY_GLOBAL_DB}"
		  //echo config.DB_HOST
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

