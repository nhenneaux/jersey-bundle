package com.github.nhenneaux.jersey.bundle;

import java.io.IOException;

public class Bootstrap {

    public static void main(String[] args) throws IOException {
        JettyServer.TlsSecurityConfiguration tlsSecurityConfiguration = new JettyServer.TlsSecurityConfiguration(
                JettyServer.TlsSecurityConfiguration.getKeyStore("TEST==ONLY==jks-keystore-password".toCharArray(), "keystore.p12"),
                "server",
                "TEST==ONLY==jks-keystore-password",
                "TLSv1.2"
        );
        try (JettyServer ignored = new JettyServer(8080, tlsSecurityConfiguration, DummyRestService.class)) {
            //noinspection ResultOfMethodCallIgnored
            System.in.read();
        }
    }
}
