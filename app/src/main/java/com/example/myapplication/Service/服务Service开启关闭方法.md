服务Service从一定的角度来看，可以将其理解为没有界面的Activity，

Service的生命周期方法比Activity少一些，只有onCreate, onStart, onDestroy

其中服务还分为两种使用，

第一种是开启关闭，第二种是绑定和解绑，



开启服务（startService）

服务一旦开启就与调用者没有任何关系， 当调用者Activity退出时，服务仍在运行，不会影响后台service的运行。

在Activity中不能调用服务里面的方法



绑定服务（bindService）

通过绑定方式开启服务，服务跟服务不求同生，但求同死。如果调用者的Activity退出了，那他绑定的服务也会跟着退出。

在Activity中能调用服务里面的方法




第一种，开始就执行oncreate，和onstart，结束时直接destroy，

而且调用者退出的时候这个服务不会退出，下次调用者再次上线时，依然可以关闭这个服务

就是说这个服务可以独立生活

第一种现象是这样