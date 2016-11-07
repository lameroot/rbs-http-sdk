package ru.rbs.http.api.client;

import ru.rbs.http.api.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static ru.rbs.http.api.util.Common.checkNotNull;

/**
 * Logging wrapper for server responses
 * Supposes, that responses in UTF-8
 */
final class ResponseLoggingInputStream extends InputStream {

    private static final String TAG = ResponseLoggingInputStream.class.getName();

    private final InputStream inputStream;
    private final ByteArrayOutputStream buffer;

    ResponseLoggingInputStream(InputStream inputStream) {
        this.inputStream = checkNotNull(inputStream, "input stream");
        this.buffer = new ByteArrayOutputStream();
    }

    @Override
    public int read() throws IOException {
        int c = inputStream.read();
        if (c > -1) {
            buffer.write((byte) c);
        }
        return c;
    }

    @Override
    public int read(byte b[]) throws IOException {
        int read = inputStream.read(b);
        if (read > -1) {
            buffer.write(b, 0, read);
        }
        return read;
    }

    @Override
    public int read(byte b[], int off, int len) throws IOException {
        int read = inputStream.read(b, off, len);
        if (read > -1) {
            buffer.write(b, off, read);
        }
        return read;
    }

    @Override
    public void close() throws IOException {
        inputStream.close();
        buffer.close();
        Log.i(TAG, buffer.toString("UTF-8"));
    }
}
