import com.pdist.tutorial.HelloRequest;
import com.pdist.tutorial.HelloResponse;
import com.pdist.tutorial.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8081)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub
                = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                .setFirstName("Pablo")
                .setLastName("Fernandes")
                .build());
        System.out.println(helloResponse.getGreeting());
        channel.shutdown();
    }
}
