node
{
stage('Read SCM from GIT')
{
git "https://github.com/madhuri1127/UnHealthy-App"
 
}
 stage('Compile Package')
{
if(true)
	{
 sh "mvn clean install"

	}
	else
	{
		echo 'hellooooo'
	}
}

stage('Test Code Coverage')
{
	
sh "mvn test"
 
}
 
stage('ZAP Security Scan')
 {
	
	
	 
  sh './a.sh'
 }
	
	
  stage('Security Scan Report')
 {
  publishHTML (target: [
      allowMissing: false,
      alwaysLinkToLastBuild: false,
      keepAll: true,
	   reportDir: './',
      reportFiles: 'localtest.html',
      reportName: "Security Scan Report"
    ])
 }
	
 stage('Deployment Decision')
 {
	

	 value = readFile('foo.txt').trim()
  
	
echo value
	 
  if(value =="PASS")
	 {
		 echo 'Success'
	 }
	 else
	 {
		 echo 'Review Required'
		 sh "exit 1"
	 }
 }




}