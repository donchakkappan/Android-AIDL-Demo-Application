/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: F:\\TPL - TRCU - Local Workspace\\AIDLDemo\\src\\com\\ges\\aidldemo\\ISubtractService.aidl
 */
package com.ges.aidldemo;
public interface ISubtractService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.ges.aidldemo.ISubtractService
{
private static final java.lang.String DESCRIPTOR = "com.ges.aidldemo.ISubtractService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.ges.aidldemo.ISubtractService interface,
 * generating a proxy if needed.
 */
public static com.ges.aidldemo.ISubtractService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.ges.aidldemo.ISubtractService))) {
return ((com.ges.aidldemo.ISubtractService)iin);
}
return new com.ges.aidldemo.ISubtractService.Stub.Proxy(obj);
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
case TRANSACTION_subract:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _result = this.subract(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.ges.aidldemo.ISubtractService
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
@Override public int subract(int ValueFirst, int valueSecond) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(ValueFirst);
_data.writeInt(valueSecond);
mRemote.transact(Stub.TRANSACTION_subract, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_subract = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public int subract(int ValueFirst, int valueSecond) throws android.os.RemoteException;
}
