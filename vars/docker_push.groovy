// def call(String Project, String ImageTag, String dockerhubuser){
//   withCredentials([usernamePassword(credentialsId: 'docker', passwordVariable: 'dockerhubpass', usernameVariable: 'dockerhubuser')]) {
//       sh "docker login -u ${dockerhubuser} -p ${dockerhubpass}"
//   }
//   sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
// }

def call(String project, String imageTag, String dockerHubUser) {
    withCredentials([string(credentialsId: 'dockerhub-token', variable: 'DOCKERHUB_TOKEN')]) {
        sh '''
          echo "$DOCKERHUB_TOKEN" | docker login -u ''' + dockerHubUser + ''' --password-stdin
          docker push ''' + dockerHubUser + '''/''' + project + ''':'''+ imageTag + '''
        '''
    }
}

