
def getAllEnvVars(host) {
	echo host 
	DB_HOST = host 
}

def call(body) {
  def config = [:]
  body.resolveStrategy = Closure.DELEGATE_FIRST
  body.delegate = config 
  body()

  pipeline {
    agent any 

	environment { 
		DB_HOST = getAllEnvVars(config.DB_HOST)
	}
	
	stages {
	  stage('Build') {
	    steps { 
		  echo "inside build"
		  echo "${DB_HOST}"
		  echo "Global db = ${MY_GLOBAL_DB}"
		  script { 
			if (config.DB_HOST != null) {
				echo "displaying DB_HOST"
				echo config.DB_HOST
			}
		  
			if (config.JUNK != null) {
				echo "displaying JUNK"
				echo config.JUNK
			}
		  } // end of script 
		} // end of build 
	  }
	  stage('deploy') {
	    steps { 
		  echo "inside deploy"
		}
	  }
	}
  }
}

