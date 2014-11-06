/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/Inge/Desktop/workspace.sman7.services.and.broadcastreceiver/de.vogella.android.ownservice.aidl/src/de/vogella/android/ownservice/aidl/IWordService.aidl
 */
package de.vogella.android.ownservice.aidl;
public interface IWordService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements de.vogella.android.ownservice.aidl.IWordService
{
private static final java.lang.String DESCRIPTOR = "de.vogella.android.ownservice.aidl.IWordService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an de.vogella.android.ownservice.aidl.IWordService interface,
 * generating a proxy if needed.
 */
public static de.vogella.android.ownservice.aidl.IWordService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof de.vogella.android.ownservice.aidl.IWordService))) {
return ((de.vogella.android.ownservice.aidl.IWordService)iin);
}
return new de.vogella.android.ownservice.aidl.IWordService.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getWords:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<de.vogella.android.ownservice.aidl.MyMessage> _result = this.getWords();
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements de.vogella.android.ownservice.aidl.IWordService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public java.util.List<de.vogella.android.ownservice.aidl.MyMessage> getWords() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<de.vogella.android.ownservice.aidl.MyMessage> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getWords, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(de.vogella.android.ownservice.aidl.MyMessage.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_getWords = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public java.util.List<de.vogella.android.ownservice.aidl.MyMessage> getWords() throws android.os.RemoteException;
}
