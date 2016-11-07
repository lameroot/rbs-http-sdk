package ru.rbs.http.api.client;

import ru.rbs.http.api.util.Log;
import ru.rbs.http.api.util.Numbers;

import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.SocketChannel;

import static ru.rbs.http.api.util.Common.checkNotNull;

final class WireLoggingSocketFactory extends SSLSocketFactory {

    private static final String TAG = WireLoggingSocketFactory.class.getName();

    private final SSLSocketFactory delegate;

    WireLoggingSocketFactory(SSLSocketFactory sslSocketFactory) {
        this.delegate = checkNotNull(sslSocketFactory, "sslSocketFactory");
    }

    @Override
    public String[] getDefaultCipherSuites() {
        return delegate.getDefaultCipherSuites();
    }

    @Override
    public String[] getSupportedCipherSuites() {
        return delegate.getSupportedCipherSuites();
    }

    public Socket createSocket(Socket s, String host, int port,
                               boolean autoClose) throws IOException {
        Log.i(TAG, "Creating socket: " + host + ":" + port);
        return new WireLogSocket((SSLSocket) delegate.createSocket(s, host, port, autoClose));
    }

    @Override
    public Socket createSocket(String s, int i) throws IOException {
        Log.i(TAG, "Creating socket: " + s + ":" + i);
        return new WireLogSocket((SSLSocket) delegate.createSocket(s, i));
    }

    @Override
    public Socket createSocket(String s, int i, InetAddress inetAddress, int i2) throws IOException {
        Log.i(TAG, "Creating socket: " + inetAddress);
        return new WireLogSocket((SSLSocket) delegate.createSocket(s, i, inetAddress, i2));
    }

    @Override
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        Log.i(TAG, "Creating socket: " + inetAddress);
        return new WireLogSocket((SSLSocket) delegate.createSocket(inetAddress, i));
    }

    @Override
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        Log.i(TAG, "Creating socket: " + inetAddress);
        return new WireLogSocket((SSLSocket) delegate.createSocket(inetAddress, i, inetAddress2, i2));
    }

    private static class WireLogSocket extends SSLSocket {
        private final SSLSocket delegate;

        WireLogSocket(SSLSocket s) {
            super();
            this.delegate = s;
        }

        private static void logWire(String prefix, byte[] data, int off, int len) {
            StringBuilder buffer = new StringBuilder(prefix)
                    .append(" block buffer ")
                    .append(data.length)
                    .append(" offset ")
                    .append(off)
                    .append(" length ")
                    .append(len)
                    .append('\n');
            for (int i = 0; i < len; i++) {
                byte b = data[off + i];
                if (b == 13) {
                    buffer.append("[\\r]");
                } else if (b == 10) {
                    buffer.append("[\\n]\n");
                } else if (b < 32) {
                    buffer.append(" ").append(Numbers.byteToHex(b));
                } else {
                    buffer.append((char) b);
                }
            }
            Log.i(TAG, buffer.toString());
        }

        @Override
        public OutputStream getOutputStream() throws IOException {
            return new LoggingOutputStream(delegate.getOutputStream());
        }

        @Override
        public InputStream getInputStream() throws IOException {
            return new LoggingInputStream(delegate.getInputStream());
        }

        @Override
        public String[] getSupportedCipherSuites() {
            return delegate.getSupportedCipherSuites();
        }

        @Override
        public String[] getEnabledCipherSuites() {
            return delegate.getEnabledCipherSuites();
        }

        @Override
        public void setEnabledCipherSuites(String[] strings) {
            delegate.setEnabledCipherSuites(strings);
        }

        @Override
        public String[] getSupportedProtocols() {
            return delegate.getSupportedProtocols();
        }

        @Override
        public String[] getEnabledProtocols() {
            return delegate.getEnabledProtocols();
        }

        @Override
        public void setEnabledProtocols(String[] strings) {
            delegate.setEnabledProtocols(strings);
        }

        @Override
        public SSLSession getSession() {
            return delegate.getSession();
        }

        @Override
        public void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
            delegate.addHandshakeCompletedListener(handshakeCompletedListener);
        }

        @Override
        public void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
            delegate.removeHandshakeCompletedListener(handshakeCompletedListener);
        }

        @Override
        public void startHandshake() throws IOException {
            delegate.startHandshake();
        }

        @Override
        public boolean getUseClientMode() {
            return delegate.getUseClientMode();
        }

        @Override
        public void setUseClientMode(boolean b) {
            delegate.setUseClientMode(b);
        }

        @Override
        public boolean getNeedClientAuth() {
            return delegate.getNeedClientAuth();
        }

        @Override
        public void setNeedClientAuth(boolean b) {
            delegate.setNeedClientAuth(b);
        }

        @Override
        public boolean getWantClientAuth() {
            return delegate.getWantClientAuth();
        }

        @Override
        public void setWantClientAuth(boolean b) {
            delegate.setWantClientAuth(b);
        }

        @Override
        public boolean getEnableSessionCreation() {
            return delegate.getEnableSessionCreation();
        }

        @Override
        public void setEnableSessionCreation(boolean b) {
            delegate.setEnableSessionCreation(b);
        }

        @Override
        public void close() throws IOException {
            delegate.close();
        }

        @Override
        public InetAddress getInetAddress() {
            return delegate.getInetAddress();
        }

        @Override
        public boolean getKeepAlive() throws SocketException {
            return delegate.getKeepAlive();
        }

        @Override
        public InetAddress getLocalAddress() {
            return delegate.getLocalAddress();
        }

        @Override
        public int getLocalPort() {
            return delegate.getLocalPort();
        }

        @Override
        public int getPort() {
            return delegate.getPort();
        }

        @Override
        public int getSoLinger() throws SocketException {
            return delegate.getSoLinger();
        }

        @Override
        public int getReceiveBufferSize() throws SocketException {
            return delegate.getReceiveBufferSize();
        }

        @Override
        public int getSendBufferSize() throws SocketException {
            return delegate.getSendBufferSize();
        }

        @Override
        public int getSoTimeout() throws SocketException {
            return delegate.getSoTimeout();
        }

        @Override
        public boolean getTcpNoDelay() throws SocketException {
            return delegate.getTcpNoDelay();
        }

        @Override
        public void setKeepAlive(boolean keepAlive) throws SocketException {
            delegate.setKeepAlive(keepAlive);
        }

        @Override
        public void setSendBufferSize(int size) throws SocketException {
            delegate.setSendBufferSize(size);
        }

        @Override
        public void setReceiveBufferSize(int size) throws SocketException {
            delegate.setReceiveBufferSize(size);
        }

        @Override
        public void setSoLinger(boolean on, int timeout) throws SocketException {
            delegate.setSoLinger(on, timeout);
        }

        @Override
        public void setSoTimeout(int timeout) throws SocketException {
            delegate.setSoTimeout(timeout);
        }

        @Override
        public void setTcpNoDelay(boolean on) throws SocketException {
            delegate.setTcpNoDelay(on);
        }

        @Override
        public String toString() {
            return "WireLogSocket={" + delegate.toString() + '}';
        }

        @Override
        public void shutdownInput() throws IOException {
            delegate.shutdownInput();
        }

        @Override
        public void shutdownOutput() throws IOException {
            delegate.shutdownOutput();
        }

        @Override
        public SocketAddress getLocalSocketAddress() {
            return delegate.getLocalSocketAddress();
        }

        @Override
        public SocketAddress getRemoteSocketAddress() {
            return delegate.getRemoteSocketAddress();
        }

        @Override
        public boolean isBound() {
            return delegate.isBound();
        }

        @Override
        public boolean isConnected() {
            return delegate.isConnected();
        }

        @Override
        public boolean isClosed() {
            return delegate.isClosed();
        }

        @Override
        public void bind(SocketAddress localAddr) throws IOException {
            delegate.bind(localAddr);
        }

        @Override
        public void connect(SocketAddress remoteAddr) throws IOException {
            delegate.connect(remoteAddr);
        }

        @Override
        public void connect(SocketAddress remoteAddr, int timeout) throws IOException {
            delegate.connect(remoteAddr, timeout);
        }

        @Override
        public boolean isInputShutdown() {
            return delegate.isInputShutdown();
        }

        @Override
        public boolean isOutputShutdown() {
            return delegate.isOutputShutdown();
        }

        @Override
        public void setReuseAddress(boolean reuse) throws SocketException {
            delegate.setReuseAddress(reuse);
        }

        @Override
        public boolean getReuseAddress() throws SocketException {
            return delegate.getReuseAddress();
        }

        @Override
        public void setOOBInline(boolean oobinline) throws SocketException {
            delegate.setOOBInline(oobinline);
        }

        @Override
        public boolean getOOBInline() throws SocketException {
            return delegate.getOOBInline();
        }

        @Override
        public void setTrafficClass(int value) throws SocketException {
            delegate.setTrafficClass(value);
        }

        @Override
        public int getTrafficClass() throws SocketException {
            return delegate.getTrafficClass();
        }

        @Override
        public void sendUrgentData(int value) throws IOException {
            delegate.sendUrgentData(value);
        }

        @Override
        public SocketChannel getChannel() {
            return delegate.getChannel();
        }

        @Override
        public void setPerformancePreferences(int connectionTime, int latency, int bandwidth) {
            delegate.setPerformancePreferences(connectionTime, latency, bandwidth);
        }

        private static class LoggingOutputStream extends FilterOutputStream {
            LoggingOutputStream(OutputStream out) {
                super(out);
            }

            @Override
            public void write(byte[] b, int off, int len)
                    throws IOException {
                out.write(b, off, len);
                logWire("WRITE:", b, off, len);
            }

            @Override
            public void write(int b) throws IOException {
                out.write(b);
                logWire("WRITE:", new byte[]{(byte) b}, 0, 1);
            }

        }

        private static class LoggingInputStream extends FilterInputStream {
            LoggingInputStream(InputStream out) {
                super(out);
            }

            @Override
            public int read() throws IOException {
                int b = in.read();
                if (b >= 0) {
                    logWire("READ:", new byte[]{(byte) b}, 0, 1);
                }
                return b;
            }

            @Override
            public int read(byte b[], int off, int len) throws IOException {
                int result = in.read(b, off, len);
                if (result > 0) {
                    logWire("READ:", b, off, result);
                }
                return result;
            }

        }
    }
}