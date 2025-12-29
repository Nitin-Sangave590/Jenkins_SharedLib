// // Define function
// def call(String ProjectName, String ImageTag, String DockerHubUser){
//   sh "docker build -t ${DockerHubUser}/${ProjectName}:${ImageTag} ."
// }


def call(String projectName, String imageTag, String dockerHubUser) {
    sh "docker build -t ${dockerHubUser}/${projectName}:${imageTag} ."
}
