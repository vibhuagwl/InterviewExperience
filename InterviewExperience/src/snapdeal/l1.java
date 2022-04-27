package snapdeal;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

class RateLimiter {
	String requestId;
	Long timestamp;
	int reqCount;
	Queue<RateLimiter> qu = new ArrayDeque<>();

	public RateLimiter(String requestId, Long timeStamp) {
		this.requestId = requestId;
		this.timestamp = timeStamp;

	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public void setReqCount(int reqCount) {
		this.reqCount = reqCount;
	}

	public boolean acceptReq(RateLimiter rateLimiter) {
		if (rateLimiter.reqCount > 100) {
			return false;
		} else {
			while (qu.peek().timestamp < timestamp - 3000L) {
				qu.remove();
			}
			qu.add(new RateLimiter(requestId, timestamp));
			return true;
		}
	}

}

public class l1 {
	public static void main(String[] args) {
		/*
		 * RateLimiter rateLimiter = new RateLimiter(Random,
		 * System.currentTimeMillis()); rateLimiter.setReqCount(rateLimiter.reqCount++);
		 * rateLimiter.acceptReq("", System.currentTimeMillis());
		 */

	}

}
