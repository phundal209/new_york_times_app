# new_york_times_app
Sample demo to show end to end MVP pattern with NYTimes of Movie Reviews



Architecture Design

MVP Pattern - Uses the following libraries

UI
-----------------
Dagger
Butterknife
Picasso

Networking
----------------
OKHttp

API
---------------
Retrofit
RxJava
Kotlin
GSON


How it works:

The app is modularized in to sub-modules to work as follows:

app - handles the UI layer of the app. Establishes an injection framework
to handle D.I. and uses Dagger to create MVP scaffold.

api - handles the deserialization of responses and requests by using GSON.
This is highly scalable, as an app grows the assumption is that the models
used will increase and can be found here.

services - handles the background processes made by the app. Follows the 
observable pattern to make requests and return observables to be observed
in the app module.


At a lower level, the app module has introduced a delegation schema that can 
be seen through the Activity/Presenter/Adapter used. The Services layer
handles the network requests, but it is not written to handle larger error cases.
The assumption made was the contract established is well adhered to, and was made
to follow the happy path. Obviously, this would need to be handled with different care
if more well known issues are to arise.

Also, I made the assumption that the contract will not send nulls. As seen in the
response, there are no null values returned. Further, to simplify the image render,
I made the assumption to always fallback to the size of the images inside of the
media object returned.

Lastly, I do not handle pagination here, but I see that there is a "has_more" param.
I would essentially need to adhere to the pagination contract established by the
server by either sending a timestamp of last page to get the next page, or pass
the last entry seen and expect {page_size} entries to be retrieved with another
flag of "has_more" telling me if I need to fetch more. Also, I would need to 
update the adapter to have a method that takes in addAll() to add multiple new
entries on each update.



