// AIDLInterface.aidl
package com.peerless2012.service.aidl;

// Declare any non-default types here with import statements

interface AIDLInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    String basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
}