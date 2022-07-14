package com.teewhy.food2forkkmm

import cc.popkorn.InjectorObjC
import cc.popkorn.mapping.Mapping
import cc.popkorn.popKorn
import kotlinx.cinterop.ObjCClass

// Expose the PopKorn setup function to be called from ObjectiveC as ObjectiveC won't have direct access to the library methods
fun init(creator: (ObjCClass) -> Mapping) = cc.popkorn.setup(creator)

// Gets PopKorn injector to be used in ObjectiveC classes. This does not create a new injector, but wraps the default one
fun getInjector() =
    InjectorObjC(popKorn()) // TODO Red line under *InjectorObjC, still yet to figure it out
