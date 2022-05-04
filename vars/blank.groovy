
def getAllEnvVars(host) {
	echo "inside globalAllEnvVars()" 
	echo host 
	return host
}

def call(body) {
  def config = [:]
  body.resolveStrategy = Closure.DELEGATE_FIRST
  body.delegate = config 
  body()

  pipeline {
    agent any 

	environment { 
		DB_HOST = getAllEnvVars(config.dbhost)
	}
	
	stages {
	  stage('Build') {
	    steps { 
	          echo "inside build, host is ${DB_HOST}"

		  script { 
			if (config.DB_HOST != null) {
				echo "displaying DB_HOST"
				echo "DB HOST is '${config.DB_HOST}'"
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

