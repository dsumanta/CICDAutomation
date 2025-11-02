def call(Map config = [:]) {
    def imageName = config.imageName ?: error("Image name is required")
    def imageTag = config.imageTag ?: 'latest'
    def dockerfile = config.dockerfile ?: 'Dockerfile'
    def context = config.context ?: '.'
    def username = config.username ?: ''
    
    echo "Building Docker image: ${username}/${imageName}:${imageTag} using ${dockerfile}"
    
    sh """
        docker build -t ${username}/${imageName}:${imageTag} -t ${username}/${imageName}:latest -f ${dockerfile} ${context}
    """
}
