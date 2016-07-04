package com.spring.cas.client1.cert;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class DummyHostnameVerifier implements HostnameVerifier,
		com.sun.net.ssl.HostnameVerifier {

	public boolean verify(String s, SSLSession sslSession) {
		return true;
	}

	public boolean verify(String s, String s1) {
		return true;
	}
}