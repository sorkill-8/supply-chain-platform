package com.wrappers;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tuples.generated.Tuple5;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/LFDT-web3j/web3j/tree/main/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.7.0.
 */
@SuppressWarnings("rawtypes")
public class Certification extends Contract {
    public static final String BINARY = "6080604052348015600e575f5ffd5b50335f5f6101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550611c3a8061005b5f395ff3fe608060405234801561000f575f5ffd5b5060043610610091575f3560e01c80639726dd19116100645780639726dd1914610155578063c7a69e0b14610185578063e152e424146101b9578063e2d5d322146101e9578063f851a4401461021b57610091565b80630a9862cc146100955780630f10ee0b146100c55780633f185b6c146100f557806353efc82814610125575b5f5ffd5b6100af60048036038101906100aa91906110fd565b610239565b6040516100bc9190611171565b60405180910390f35b6100df60048036038101906100da919061124e565b610383565b6040516100ec9190611171565b60405180910390f35b61010f600480360381019061010a919061131e565b6104e7565b60405161011c9190611171565b60405180910390f35b61013f600480360381019061013a919061131e565b610650565b60405161014c9190611171565b60405180910390f35b61016f600480360381019061016a9190611349565b610782565b60405161017c9190611171565b60405180910390f35b61019f600480360381019061019a919061131e565b6108b8565b6040516101b09594939291906113f0565b60405180910390f35b6101d360048036038101906101ce919061145d565b610b8f565b6040516101e09190611171565b60405180910390f35b61020360048036038101906101fe9190611349565b610d98565b60405161021293929190611606565b60405180910390f35b610223610e98565b6040516102309190611642565b60405180910390f35b5f3373ffffffffffffffffffffffffffffffffffffffff166002846040516102619190611695565b90815260200160405180910390205f015f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16146102e7576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016102de9061171b565b60405180910390fd5b6002836040516102f79190611695565b908152602001604051809103902060010182908060018154018082558091505060019003905f5260205f20015f90919091909150558260405161033a9190611695565b60405180910390207fd6992432077f798bd16fdc802e8508cd0e2293105eecbcfba8bd8a785a505d5c836040516103719190611739565b60405180910390a26001905092915050565b5f5f8351036103c7576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016103be9061179c565b60405180910390fd5b60405180606001604052803373ffffffffffffffffffffffffffffffffffffffff168152602001838152602001428152506002846040516104089190611695565b90815260200160405180910390205f820151815f015f6101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506020820151816001019080519060200190610476929190610ebc565b50604082015181600201559050503373ffffffffffffffffffffffffffffffffffffffff16836040516104a99190611695565b60405180910390207f4cc39cf92556f56ba17184d656cf1bbcfd5f8e8d7b1071d0e295017b9f70f41b60405160405180910390a36001905092915050565b5f5f5f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610576576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161056d9061182a565b60405180910390fd5b60015f8373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205f5f82015f6105c29190610f07565b600182015f6105d19190610f07565b600282015f6105e09190610f07565b600382015f6105ef9190610f07565b600482015f6101000a81549060ff021916905550508173ffffffffffffffffffffffffffffffffffffffff167fb78e9906c5bae930ccf756a5214c9855b1782f0eb30f9566de2384f034af48f360405160405180910390a260019050919050565b5f5f5f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146106df576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016106d69061182a565b60405180910390fd5b6001805f8473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f206004015f6101000a81548160ff0219169083151502179055508173ffffffffffffffffffffffffffffffffffffffff167f40f58d9058b55227673bb5c98ad8171d97464140d5c62d7f9fcf877a72dca59a60405160405180910390a260019050919050565b5f5f5f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610811576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016108089061182a565b60405180910390fd5b6002826040516108219190611695565b90815260200160405180910390205f5f82015f6101000a81549073ffffffffffffffffffffffffffffffffffffffff0219169055600182015f6108649190610f44565b600282015f905550508160405161087b9190611695565b60405180910390207f1c40e49688e963884d475feda3ddb42c17aec5d2a82706904ba014ee7ce54a2a60405160405180910390a260019050919050565b6060806060805f5f60015f8873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f206040518060a00160405290815f8201805461091790611875565b80601f016020809104026020016040519081016040528092919081815260200182805461094390611875565b801561098e5780601f106109655761010080835404028352916020019161098e565b820191905f5260205f20905b81548152906001019060200180831161097157829003601f168201915b505050505081526020016001820180546109a790611875565b80601f01602080910402602001604051908101604052809291908181526020018280546109d390611875565b8015610a1e5780601f106109f557610100808354040283529160200191610a1e565b820191905f5260205f20905b815481529060010190602001808311610a0157829003601f168201915b50505050508152602001600282018054610a3790611875565b80601f0160208091040260200160405190810160405280929190818152602001828054610a6390611875565b8015610aae5780601f10610a8557610100808354040283529160200191610aae565b820191905f5260205f20905b815481529060010190602001808311610a9157829003601f168201915b50505050508152602001600382018054610ac790611875565b80601f0160208091040260200160405190810160405280929190818152602001828054610af390611875565b8015610b3e5780601f10610b1557610100808354040283529160200191610b3e565b820191905f5260205f20905b815481529060010190602001808311610b2157829003601f168201915b50505050508152602001600482015f9054906101000a900460ff1615151515815250509050805f01518160200151826040015183606001518460800151955095509550955095505091939590929450565b5f5f60015f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205f018054610bdb90611875565b905014610c1d576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610c14906118ef565b60405180910390fd5b5f855103610c60576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610c5790611957565b60405180910390fd5b6040518060a001604052808681526020018581526020018481526020018381526020015f151581525060015f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205f820151815f019081610cd99190611b15565b506020820151816001019081610cef9190611b15565b506040820151816002019081610d059190611b15565b506060820151816003019081610d1b9190611b15565b506080820151816004015f6101000a81548160ff0219169083151502179055509050503373ffffffffffffffffffffffffffffffffffffffff167f52331e1d2569e9ad196425abe1247ba2b98b22fe7c8ee9ca7491235cdbd69a9686604051610d849190611be4565b60405180910390a260019050949350505050565b5f60605f5f600285604051610dad9190611695565b90815260200160405180910390206040518060600160405290815f82015f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200160018201805480602002602001604051908101604052809291908181526020018280548015610e6757602002820191905f5260205f20905b815481526020019060010190808311610e53575b505050505081526020016002820154815250509050805f015181602001518260400151935093509350509193909250565b5f5f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b828054828255905f5260205f20908101928215610ef6579160200282015b82811115610ef5578251825591602001919060010190610eda565b5b509050610f039190610f62565b5090565b508054610f1390611875565b5f825580601f10610f245750610f41565b601f0160209004905f5260205f2090810190610f409190610f62565b5b50565b5080545f8255905f5260205f2090810190610f5f9190610f62565b50565b5b80821115610f79575f815f905550600101610f63565b5090565b5f604051905090565b5f5ffd5b5f5ffd5b5f5ffd5b5f5ffd5b5f601f19601f8301169050919050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52604160045260245ffd5b610fdc82610f96565b810181811067ffffffffffffffff82111715610ffb57610ffa610fa6565b5b80604052505050565b5f61100d610f7d565b90506110198282610fd3565b919050565b5f67ffffffffffffffff82111561103857611037610fa6565b5b61104182610f96565b9050602081019050919050565b828183375f83830152505050565b5f61106e6110698461101e565b611004565b90508281526020810184848401111561108a57611089610f92565b5b61109584828561104e565b509392505050565b5f82601f8301126110b1576110b0610f8e565b5b81356110c184826020860161105c565b91505092915050565b5f819050919050565b6110dc816110ca565b81146110e6575f5ffd5b50565b5f813590506110f7816110d3565b92915050565b5f5f6040838503121561111357611112610f86565b5b5f83013567ffffffffffffffff8111156111305761112f610f8a565b5b61113c8582860161109d565b925050602061114d858286016110e9565b9150509250929050565b5f8115159050919050565b61116b81611157565b82525050565b5f6020820190506111845f830184611162565b92915050565b5f67ffffffffffffffff8211156111a4576111a3610fa6565b5b602082029050602081019050919050565b5f5ffd5b5f6111cb6111c68461118a565b611004565b905080838252602082019050602084028301858111156111ee576111ed6111b5565b5b835b81811015611217578061120388826110e9565b8452602084019350506020810190506111f0565b5050509392505050565b5f82601f83011261123557611234610f8e565b5b81356112458482602086016111b9565b91505092915050565b5f5f6040838503121561126457611263610f86565b5b5f83013567ffffffffffffffff81111561128157611280610f8a565b5b61128d8582860161109d565b925050602083013567ffffffffffffffff8111156112ae576112ad610f8a565b5b6112ba85828601611221565b9150509250929050565b5f73ffffffffffffffffffffffffffffffffffffffff82169050919050565b5f6112ed826112c4565b9050919050565b6112fd816112e3565b8114611307575f5ffd5b50565b5f81359050611318816112f4565b92915050565b5f6020828403121561133357611332610f86565b5b5f6113408482850161130a565b91505092915050565b5f6020828403121561135e5761135d610f86565b5b5f82013567ffffffffffffffff81111561137b5761137a610f8a565b5b6113878482850161109d565b91505092915050565b5f81519050919050565b5f82825260208201905092915050565b8281835e5f83830152505050565b5f6113c282611390565b6113cc818561139a565b93506113dc8185602086016113aa565b6113e581610f96565b840191505092915050565b5f60a0820190508181035f83015261140881886113b8565b9050818103602083015261141c81876113b8565b9050818103604083015261143081866113b8565b9050818103606083015261144481856113b8565b90506114536080830184611162565b9695505050505050565b5f5f5f5f6080858703121561147557611474610f86565b5b5f85013567ffffffffffffffff81111561149257611491610f8a565b5b61149e8782880161109d565b945050602085013567ffffffffffffffff8111156114bf576114be610f8a565b5b6114cb8782880161109d565b935050604085013567ffffffffffffffff8111156114ec576114eb610f8a565b5b6114f88782880161109d565b925050606085013567ffffffffffffffff81111561151957611518610f8a565b5b6115258782880161109d565b91505092959194509250565b61153a816112e3565b82525050565b5f81519050919050565b5f82825260208201905092915050565b5f819050602082019050919050565b611572816110ca565b82525050565b5f6115838383611569565b60208301905092915050565b5f602082019050919050565b5f6115a582611540565b6115af818561154a565b93506115ba8361155a565b805f5b838110156115ea5781516115d18882611578565b97506115dc8361158f565b9250506001810190506115bd565b5085935050505092915050565b611600816110ca565b82525050565b5f6060820190506116195f830186611531565b818103602083015261162b818561159b565b905061163a60408301846115f7565b949350505050565b5f6020820190506116555f830184611531565b92915050565b5f81905092915050565b5f61166f82611390565b611679818561165b565b93506116898185602086016113aa565b80840191505092915050565b5f6116a08284611665565b915081905092915050565b7f4f6e6c79207468652070726f64756374206f776e65722063616e2075706461745f8201527f65206c6f636174696f6e00000000000000000000000000000000000000000000602082015250565b5f611705602a8361139a565b9150611710826116ab565b604082019050919050565b5f6020820190508181035f830152611732816116f9565b9050919050565b5f60208201905061174c5f8301846115f7565b92915050565b7f53657269616c206e756d626572207265717569726564000000000000000000005f82015250565b5f61178660168361139a565b915061179182611752565b602082019050919050565b5f6020820190508181035f8301526117b38161177a565b9050919050565b7f4f6e6c792061646d696e2063616e20706572666f726d207468697320616374695f8201527f6f6e000000000000000000000000000000000000000000000000000000000000602082015250565b5f61181460228361139a565b915061181f826117ba565b604082019050919050565b5f6020820190508181035f83015261184181611808565b9050919050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52602260045260245ffd5b5f600282049050600182168061188c57607f821691505b60208210810361189f5761189e611848565b5b50919050565b7f50726f647563657220616c7265616479206578697374730000000000000000005f82015250565b5f6118d960178361139a565b91506118e4826118a5565b602082019050919050565b5f6020820190508181035f830152611906816118cd565b9050919050565b7f4e616d65207265717569726564000000000000000000000000000000000000005f82015250565b5f611941600d8361139a565b915061194c8261190d565b602082019050919050565b5f6020820190508181035f83015261196e81611935565b9050919050565b5f819050815f5260205f209050919050565b5f6020601f8301049050919050565b5f82821b905092915050565b5f600883026119d17fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff82611996565b6119db8683611996565b95508019841693508086168417925050509392505050565b5f819050919050565b5f611a16611a11611a0c846110ca565b6119f3565b6110ca565b9050919050565b5f819050919050565b611a2f836119fc565b611a43611a3b82611a1d565b8484546119a2565b825550505050565b5f5f905090565b611a5a611a4b565b611a65818484611a26565b505050565b5b81811015611a8857611a7d5f82611a52565b600181019050611a6b565b5050565b601f821115611acd57611a9e81611975565b611aa784611987565b81016020851015611ab6578190505b611aca611ac285611987565b830182611a6a565b50505b505050565b5f82821c905092915050565b5f611aed5f1984600802611ad2565b1980831691505092915050565b5f611b058383611ade565b9150826002028217905092915050565b611b1e82611390565b67ffffffffffffffff811115611b3757611b36610fa6565b5b611b418254611875565b611b4c828285611a8c565b5f60209050601f831160018114611b7d575f8415611b6b578287015190505b611b758582611afa565b865550611bdc565b601f198416611b8b86611975565b5f5b82811015611bb257848901518255600182019150602085019450602081019050611b8d565b86831015611bcf5784890151611bcb601f891682611ade565b8355505b6001600288020188555050505b505050505050565b5f6020820190508181035f830152611bfc81846113b8565b90509291505056fea2646970667358221220c9cc862b5d4515146fcd80a99e3e04f60ef901ea5ab55005be3782bcd2e7407464736f6c634300081e0033";

    private static String librariesLinkedBinary;

    public static final String FUNC_ADDPRODUCER = "addProducer";

    public static final String FUNC_ADDPRODUCT = "addProduct";

    public static final String FUNC_ADMIN = "admin";

    public static final String FUNC_CERTIFYPRODUCER = "certifyProducer";

    public static final String FUNC_FINDPRODUCER = "findProducer";

    public static final String FUNC_FINDPRODUCT = "findProduct";

    public static final String FUNC_REMOVEPRODUCER = "removeProducer";

    public static final String FUNC_REMOVEPRODUCT = "removeProduct";

    public static final String FUNC_UPDATEPRODUCTLOCATION = "updateProductLocation";

    public static final Event PRODUCERADDED_EVENT = new Event("ProducerAdded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event PRODUCERCERTIFIED_EVENT = new Event("ProducerCertified", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event PRODUCERREMOVED_EVENT = new Event("ProducerRemoved", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event PRODUCTADDED_EVENT = new Event("ProductAdded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event PRODUCTLOCATIONUPDATED_EVENT = new Event("ProductLocationUpdated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event PRODUCTREMOVED_EVENT = new Event("ProductRemoved", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>(true) {}));
    ;

    @Deprecated
    protected Certification(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Certification(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Certification(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Certification(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<ProducerAddedEventResponse> getProducerAddedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(PRODUCERADDED_EVENT, transactionReceipt);
        ArrayList<ProducerAddedEventResponse> responses = new ArrayList<ProducerAddedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ProducerAddedEventResponse typedResponse = new ProducerAddedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.producer = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.name = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static ProducerAddedEventResponse getProducerAddedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(PRODUCERADDED_EVENT, log);
        ProducerAddedEventResponse typedResponse = new ProducerAddedEventResponse();
        typedResponse.log = log;
        typedResponse.producer = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.name = (String) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<ProducerAddedEventResponse> producerAddedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getProducerAddedEventFromLog(log));
    }

    public Flowable<ProducerAddedEventResponse> producerAddedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PRODUCERADDED_EVENT));
        return producerAddedEventFlowable(filter);
    }

    public static List<ProducerCertifiedEventResponse> getProducerCertifiedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(PRODUCERCERTIFIED_EVENT, transactionReceipt);
        ArrayList<ProducerCertifiedEventResponse> responses = new ArrayList<ProducerCertifiedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ProducerCertifiedEventResponse typedResponse = new ProducerCertifiedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.producer = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static ProducerCertifiedEventResponse getProducerCertifiedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(PRODUCERCERTIFIED_EVENT, log);
        ProducerCertifiedEventResponse typedResponse = new ProducerCertifiedEventResponse();
        typedResponse.log = log;
        typedResponse.producer = (String) eventValues.getIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<ProducerCertifiedEventResponse> producerCertifiedEventFlowable(
            EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getProducerCertifiedEventFromLog(log));
    }

    public Flowable<ProducerCertifiedEventResponse> producerCertifiedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PRODUCERCERTIFIED_EVENT));
        return producerCertifiedEventFlowable(filter);
    }

    public static List<ProducerRemovedEventResponse> getProducerRemovedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(PRODUCERREMOVED_EVENT, transactionReceipt);
        ArrayList<ProducerRemovedEventResponse> responses = new ArrayList<ProducerRemovedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ProducerRemovedEventResponse typedResponse = new ProducerRemovedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.producer = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static ProducerRemovedEventResponse getProducerRemovedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(PRODUCERREMOVED_EVENT, log);
        ProducerRemovedEventResponse typedResponse = new ProducerRemovedEventResponse();
        typedResponse.log = log;
        typedResponse.producer = (String) eventValues.getIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<ProducerRemovedEventResponse> producerRemovedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getProducerRemovedEventFromLog(log));
    }

    public Flowable<ProducerRemovedEventResponse> producerRemovedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PRODUCERREMOVED_EVENT));
        return producerRemovedEventFlowable(filter);
    }

    public static List<ProductAddedEventResponse> getProductAddedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(PRODUCTADDED_EVENT, transactionReceipt);
        ArrayList<ProductAddedEventResponse> responses = new ArrayList<ProductAddedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ProductAddedEventResponse typedResponse = new ProductAddedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.serialNo = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.producer = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static ProductAddedEventResponse getProductAddedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(PRODUCTADDED_EVENT, log);
        ProductAddedEventResponse typedResponse = new ProductAddedEventResponse();
        typedResponse.log = log;
        typedResponse.serialNo = (byte[]) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.producer = (String) eventValues.getIndexedValues().get(1).getValue();
        return typedResponse;
    }

    public Flowable<ProductAddedEventResponse> productAddedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getProductAddedEventFromLog(log));
    }

    public Flowable<ProductAddedEventResponse> productAddedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PRODUCTADDED_EVENT));
        return productAddedEventFlowable(filter);
    }

    public static List<ProductLocationUpdatedEventResponse> getProductLocationUpdatedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(PRODUCTLOCATIONUPDATED_EVENT, transactionReceipt);
        ArrayList<ProductLocationUpdatedEventResponse> responses = new ArrayList<ProductLocationUpdatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ProductLocationUpdatedEventResponse typedResponse = new ProductLocationUpdatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.serialNo = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.location = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static ProductLocationUpdatedEventResponse getProductLocationUpdatedEventFromLog(
            Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(PRODUCTLOCATIONUPDATED_EVENT, log);
        ProductLocationUpdatedEventResponse typedResponse = new ProductLocationUpdatedEventResponse();
        typedResponse.log = log;
        typedResponse.serialNo = (byte[]) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.location = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<ProductLocationUpdatedEventResponse> productLocationUpdatedEventFlowable(
            EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getProductLocationUpdatedEventFromLog(log));
    }

    public Flowable<ProductLocationUpdatedEventResponse> productLocationUpdatedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PRODUCTLOCATIONUPDATED_EVENT));
        return productLocationUpdatedEventFlowable(filter);
    }

    public static List<ProductRemovedEventResponse> getProductRemovedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(PRODUCTREMOVED_EVENT, transactionReceipt);
        ArrayList<ProductRemovedEventResponse> responses = new ArrayList<ProductRemovedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ProductRemovedEventResponse typedResponse = new ProductRemovedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.serialNo = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static ProductRemovedEventResponse getProductRemovedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(PRODUCTREMOVED_EVENT, log);
        ProductRemovedEventResponse typedResponse = new ProductRemovedEventResponse();
        typedResponse.log = log;
        typedResponse.serialNo = (byte[]) eventValues.getIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<ProductRemovedEventResponse> productRemovedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getProductRemovedEventFromLog(log));
    }

    public Flowable<ProductRemovedEventResponse> productRemovedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PRODUCTREMOVED_EVENT));
        return productRemovedEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> addProducer(String _name, String _phoneNo,
            String _cityState, String _country) {
        final Function function = new Function(
                FUNC_ADDPRODUCER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_phoneNo), 
                new org.web3j.abi.datatypes.Utf8String(_cityState), 
                new org.web3j.abi.datatypes.Utf8String(_country)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addProduct(String serialNo,
            List<BigInteger> _locationData) {
        final Function function = new Function(
                FUNC_ADDPRODUCT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(serialNo), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(_locationData, org.web3j.abi.datatypes.generated.Uint256.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> admin() {
        final Function function = new Function(FUNC_ADMIN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> certifyProducer(String _producer) {
        final Function function = new Function(
                FUNC_CERTIFYPRODUCER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _producer)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple5<String, String, String, String, Boolean>> findProducer(
            String _producer) {
        final Function function = new Function(FUNC_FINDPRODUCER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _producer)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Bool>() {}));
        return new RemoteFunctionCall<Tuple5<String, String, String, String, Boolean>>(function,
                new Callable<Tuple5<String, String, String, String, Boolean>>() {
                    @Override
                    public Tuple5<String, String, String, String, Boolean> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<String, String, String, String, Boolean>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (Boolean) results.get(4).getValue());
                    }
                });
    }

    public RemoteFunctionCall<Tuple3<String, List<BigInteger>, BigInteger>> findProduct(
            String serialNo) {
        final Function function = new Function(FUNC_FINDPRODUCT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(serialNo)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple3<String, List<BigInteger>, BigInteger>>(function,
                new Callable<Tuple3<String, List<BigInteger>, BigInteger>>() {
                    @SuppressWarnings("unchecked")
					@Override
                    public Tuple3<String, List<BigInteger>, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, List<BigInteger>, BigInteger>(
                                (String) results.get(0).getValue(), 
                                convertToNative((List<Uint256>) results.get(1).getValue()), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> removeProducer(String _producer) {
        final Function function = new Function(
                FUNC_REMOVEPRODUCER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _producer)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> removeProduct(String serialNo) {
        final Function function = new Function(
                FUNC_REMOVEPRODUCT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(serialNo)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> updateProductLocation(String serialNo,
            BigInteger newLocation) {
        final Function function = new Function(
                FUNC_UPDATEPRODUCTLOCATION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(serialNo), 
                new org.web3j.abi.datatypes.generated.Uint256(newLocation)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Certification load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new Certification(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Certification load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Certification(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Certification load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new Certification(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Certification load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Certification(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Certification> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Certification.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    public static RemoteCall<Certification> deploy(Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Certification.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<Certification> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Certification.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<Certification> deploy(Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Certification.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    /*
    public static void linkLibraries(List<Contract.LinkReference> references) {
        librariesLinkedBinary = linkBinaryWithReferences(BINARY, references);
    }
    */

    private static String getDeploymentBinary() {
        if (librariesLinkedBinary != null) {
            return librariesLinkedBinary;
        } else {
            return BINARY;
        }
    }

    public static class ProducerAddedEventResponse extends BaseEventResponse {
        public String producer;

        public String name;
    }

    public static class ProducerCertifiedEventResponse extends BaseEventResponse {
        public String producer;
    }

    public static class ProducerRemovedEventResponse extends BaseEventResponse {
        public String producer;
    }

    public static class ProductAddedEventResponse extends BaseEventResponse {
        public byte[] serialNo;

        public String producer;
    }

    public static class ProductLocationUpdatedEventResponse extends BaseEventResponse {
        public byte[] serialNo;

        public BigInteger location;
    }

    public static class ProductRemovedEventResponse extends BaseEventResponse {
        public byte[] serialNo;
    }
}
