# Kweb on Google App Engine flexible environment (not working)

This is my attempt at getting a [Kweb](https://github.com/kwebio/kweb-core) hello world app to run on Google App Engine
flexible environment with Kotlin + Gradle. It is running as a Ktor instance with Kweb attached. The page loads
successfully, but the websocket
requests are met with 501 errors and I have been unsuccessful in identifying the cause.

This repository is made from my (working) [Ktor on GAE flexible](https://github.com/heathwinning/ktor-gae-flex)
repository, with Kweb attached and websockets enabled in `app.yaml` as 'documented' in
[GAE Web Socket Example](https://github.com/GoogleCloudPlatform/java-docs-samples/tree/master/appengine-java8/websocket-jetty#app-engine-flex-deployment)
```yaml
env_variables:
  JETTY_MODULES_ENABLE: websocket
```
I also tried using a single instance, and enabling session affinity, but neither seems to have made a difference
```yaml
manual_scaling:
  instances: 1
network:
  session_affinity: true
```
