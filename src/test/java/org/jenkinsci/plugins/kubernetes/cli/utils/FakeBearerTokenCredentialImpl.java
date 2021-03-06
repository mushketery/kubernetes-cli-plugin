package org.jenkinsci.plugins.kubernetes.cli.utils;


import com.cloudbees.plugins.credentials.CredentialsScope;
import com.cloudbees.plugins.credentials.impl.UsernamePasswordCredentialsImpl;
import org.jenkinsci.plugins.kubernetes.credentials.TokenProducer;

import java.io.IOException;

public class FakeBearerTokenCredentialImpl extends UsernamePasswordCredentialsImpl implements TokenProducer {

    public FakeBearerTokenCredentialImpl(CredentialsScope scope, String id, String description, String username, String password) {
        super(scope, id, description, username, password);
    }

    @Override
    public String getToken(String serviceAddress, String caCertData, boolean skipTlsVerify) throws IOException {
        return "faketoken:" + this.getUsername() + ":" + this.getPassword();
    }
}