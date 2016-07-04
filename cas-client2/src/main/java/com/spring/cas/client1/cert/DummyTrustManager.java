package com.spring.cas.client1.cert;

import java.security.cert.X509Certificate;

import com.sun.net.ssl.X509TrustManager;

public class DummyTrustManager implements X509TrustManager {

	public DummyTrustManager() {
	}

	public boolean isClientTrusted(X509Certificate cert[]) {
		return true;
	}

	public boolean isServerTrusted(X509Certificate cert[]) {
		return true;
	}

	public X509Certificate[] getAcceptedIssuers() {
		return new X509Certificate[0];
	}
}
