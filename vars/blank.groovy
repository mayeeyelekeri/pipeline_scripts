def log_message(msg) { 
	echo "Message from code: ${msg}"	
}

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
	
	  switch (config.type) { 
		    	case 'info': log_info config.message
			    break 
			case 'warning': log_info config.message
			    break
			default: log_info "no message"
		    } // end of switch
		    
	  
	stages {
	  stage('Build') {
	    steps {
		    
	          echo "inside build, host is ${DB_HOST}"

		  script { 
			  echo "DB HOST is '${config.DB_HOST}'"
			   echo "DB HOST is '${config.dbhost}'"
			  // echo "all params  '${config.*}'"
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

