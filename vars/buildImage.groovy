def call() {
    echo 'building the docker image'
    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'PASS', usernameVariable: 'USER')]){
        sh 'docker build -t dm1984/demo-app:jma-2.0 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push dm1984/demo-app:jma-2.0'
    }  
}
