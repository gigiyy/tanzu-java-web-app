# create class claims for postgresql database

- use `tanzu service class list` to find proper name for class name and its details about parameters
- create class claims using the class:
```
tanzu servcie class-claim create postgresql-db-1 --class postgresql-unmanaged --parameter storageGB=5
```
- use the class claim info in `workload.yaml` or using `tanzu cli` to create the workload
```
tanzu apps workload create tanzu-java-web-app --git-repo https://github.com/gigiyy/tanzu-java-web-app.git --git-branch main --type web --label app.kubernetes.io/part-of=tanzu-java-app --annotation autoscaling.knative.dev/minScale=1 --service-ref="db=services.apps.tanzu.vmware.com/v1alpha1:ClassClaim:postgresql-db-1"
```

# tanzu-java-web-app

This is a sample of a Java Spring app that works with Tilt and the Tanzu Application Platform.

## Dependencies
1. [kubectl CLI](https://kubernetes.io/docs/tasks/tools/)
1. [Tilt version >= v0.23.2](https://docs.tilt.dev/install.html)
1. Tanzu CLI and the apps plugin v0.2.0 which are provided as part of [Tanzu Application Platform](https://network.tanzu.vmware.com/products/tanzu-application-platform)
1. A cluster with Tanzu Application Platform, and the "Default Supply Chain", plus its dependencies. This supply chains is part of [Tanzu Application Platform](https://network.tanzu.vmware.com/products/tanzu-application-platform).

## Running the sample

Start the app deployment by running:

```
tilt up
```

You can hit the spacebar to open the UI in a browser. 

- > If you see an "Update error" message like the one below, then just follow the instructions and allow that context:
    ```
    Stop! tap-beta2 might be production.
    If you're sure you want to deploy there, add:
        allow_k8s_contexts('tap-beta2')
    to your Tiltfile. Otherwise, switch k8s contexts and restart Tilt.
    ```
