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
	
 publishHTML (target: [
      allowMissing: false,
      alwaysLinkToLastBuild: false,
      keepAll: true,
	   reportDir: './',
      reportFiles: 'index.html',
      reportName: "Code Coverage Report"
    ])
 
}
 
stage('ZAP Security Scan')
 {
	
	
	 
  sh './sam.sh'
	
 }
	
	
  stage('Security Scan Report')
 {
  publishHTML (target: [
      allowMissing: false,
      alwaysLinkToLastBuild: false,
      keepAll: true,
	   reportDir: './',
      reportFiles: 'localtest1.html',
      reportName: "Security Scan Report"
    ])
 }
	
 stage('Deployment Decision')
 {
	  sh './b.sh'

	 value = readFile('foo1.txt').trim()
  
	
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
