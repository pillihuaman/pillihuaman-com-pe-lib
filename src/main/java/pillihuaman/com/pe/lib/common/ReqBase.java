package pillihuaman.com.pe.lib.common;

public class ReqBase<T> {

	private RespBase.Trace trace;
	private T payload;

	public ReqBase() {
		super();
	}

	public RespBase.Trace getTrace() {
		return trace;
	}

	public void setTrace(RespBase.Trace trace) {
		this.trace = trace;
	}

	public T getPayload() {
		return payload;
	}

	public void setPayload(T payload) {
		this.payload = payload;
	}
}
