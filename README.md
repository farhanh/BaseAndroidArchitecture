# MVI Pattern with Kotlin Flow
This branch is the basic demonstration of how can we use Kotlin Flow with MVI design pattern.

## MVI vs MVVM
There is not much difference in both design patterns besides more structured approach is being used in MVI which gives it the edge over MVVM.



![alt text](https://miro.medium.com/max/1872/1*pOkE6arHvzIjCAXhIAVC5g.jpeg "MVI Design Pattern")


## MVI Approach
There is a little bit change in approach how UI communicates with the ViewModel, instead directly calling its methods or properties there are States and Events which makes the code more readable and structured.

### How it Works
Let me explain it in the sequence, you can say its a lifecycle of MVI:

- UI to start/trigger an Event
- Event to listen in the View-Model
- Action to be taken based on Event
- Action to set the Data State
- Data State to observe in UI
- Adjust UI based on Success, Error or Loading Data State

## Kotlin Flow
Basic reason of using it is the ability of emitting multiple values as compared to suspend functions which can return only one value, Since its built on top of Coroutines therefore its very easy to use and for more details, please checkout the [official documentation.](https://developer.android.com/kotlin/flow)

In this demonstration, flow facilitates RemoteDataSource to fetch data from the network and then emit its different states accordingly.

### Please checkout the code, Star it if you like and feel free to contribute to this repository!
