package com.galaxy.microservice.util.util.codec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.Security;

public class GmBaseUtil {
    static {
        Security.addProvider(new BouncyCastleProvider());
    }
}
