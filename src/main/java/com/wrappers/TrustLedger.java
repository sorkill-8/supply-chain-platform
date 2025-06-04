package com.wrappers;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
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
import org.web3j.tuples.generated.Tuple6;
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
public class TrustLedger extends Contract {
    public static final String BINARY = "608060405234801561000f575f5ffd5b5060405161284c38038061284c83398181016040528101906100319190610114565b3360015f6101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550805f5f6101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505061013f565b5f5ffd5b5f73ffffffffffffffffffffffffffffffffffffffff82169050919050565b5f6100e3826100ba565b9050919050565b6100f3816100d9565b81146100fd575f5ffd5b50565b5f8151905061010e816100ea565b92915050565b5f60208284031215610129576101286100b6565b5b5f61013684828501610100565b91505092915050565b6127008061014c5f395ff3fe608060405234801561000f575f5ffd5b50600436106100cd575f3560e01c80639d0ac07b1161008a578063b36c37df11610064578063b36c37df14610239578063e429840e1461026e578063f213af381461029e578063f851a440146102ce576100cd565b80639d0ac07b146101cd5780639f65cf05146101eb5780639f71711a14610209576100cd565b8063014ab313146100d15780630683416b146101015780630f5f817a1461013157806323218e5f146101615780632ab9226d1461017f5780634428d1501461019d575b5f5ffd5b6100eb60048036038101906100e691906119b7565b6102ec565b6040516100f891906119fa565b60405180910390f35b61011b60048036038101906101169190611a3d565b61038c565b6040516101289190611b32565b60405180910390f35b61014b600480360381019061014691906119b7565b61050b565b6040516101589190611b6c565b60405180910390f35b610169610882565b60405161017691906119fa565b60405180910390f35b61018761088e565b6040516101949190611b32565b60405180910390f35b6101b760048036038101906101b29190611cc1565b610919565b6040516101c49190611b6c565b60405180910390f35b6101d5610b39565b6040516101e29190611e1f565b60405180910390f35b6101f3610b5d565b6040516102009190611b6c565b60405180910390f35b610223600480360381019061021e9190611cc1565b610d83565b6040516102309190611b6c565b60405180910390f35b610253600480360381019061024e91906119b7565b61107e565b60405161026596959493929190611e98565b60405180910390f35b61028860048036038101906102839190611f1a565b6113de565b6040516102959190611b32565b60405180910390f35b6102b860048036038101906102b39190611f45565b611649565b6040516102c59190611b32565b60405180910390f35b6102d66118cf565b6040516102e39190611f9b565b60405180910390f35b5f5f5f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166327c06fd5836040518263ffffffff1660e01b81526004016103469190611f9b565b602060405180830381865afa158015610361573d5f5f3e3d5ffd5b505050506040513d601f19601f820116820180604052508101906103859190611fc8565b9050919050565b606060038054905083106103d5576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016103cc9061203d565b60405180910390fd5b5f82846103e29190612088565b90506003805490508111156103fa5760038054905090505b5f848261040791906120bb565b67ffffffffffffffff8111156104205761041f611b9d565b5b60405190808252806020026020018201604052801561044e5781602001602082028036833780820191505090505b5090505f8590505b828110156104ff5760038181548110610472576104716120ee565b5b905f5260205f20015f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff168287836104a791906120bb565b815181106104b8576104b76120ee565b5b602002602001019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff16815250508080600101915050610456565b50809250505092915050565b5f60015f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461059b576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016105929061218b565b60405180910390fd5b5f60025f8473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205f0180546105e6906121d6565b905003610628576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161061f90612250565b60405180910390fd5b60025f8373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205f5f82015f61067491906118f4565b600182015f61068391906118f4565b600282015f61069291906118f4565b600382015f6106a191906118f4565b600482015f6106b091906118f4565b600582015f905550505f60038054905090505f5f90505b81811015610834578373ffffffffffffffffffffffffffffffffffffffff16600382815481106106fa576106f96120ee565b5b905f5260205f20015f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff160361082757600360018361074c91906120bb565b8154811061075d5761075c6120ee565b5b905f5260205f20015f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1660038281548110610799576107986120ee565b5b905f5260205f20015f6101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060038054806107f0576107ef61226e565b5b600190038181905f5260205f20015f6101000a81549073ffffffffffffffffffffffffffffffffffffffff02191690559055610834565b80806001019150506106c7565b508273ffffffffffffffffffffffffffffffffffffffff167f278a641d7aa9abcb166cd13a30fc6d7f21034d4c003ce509a84214e11faa77c060405160405180910390a26001915050919050565b5f600380549050905090565b6060600380548060200260200160405190810160405280929190818152602001828054801561090f57602002820191905f5260205f20905b815f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190600101908083116108c6575b5050505050905090565b5f5f60025f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205f018054610965906121d6565b9050036109a7576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161099e90612250565b60405180910390fd5b8560025f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205f0190816109f39190612432565b508460025f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f206001019081610a419190612432565b508360025f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f206002019081610a8f9190612432565b508260025f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f206003019081610add9190612432565b508160025f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f206004019081610b2b9190612432565b506001905095945050505050565b5f5f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b5f60015f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610bed576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610be49061218b565b60405180910390fd5b5f5f90505b600380549050811015610d7b575f60038281548110610c1457610c136120ee565b5b905f5260205f20015f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1690505f5f5f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166327c06fd5836040518263ffffffff1660e01b8152600401610c989190611f9b565b602060405180830381865afa158015610cb3573d5f5f3e3d5ffd5b505050506040513d601f19601f82011682018060405250810190610cd79190611fc8565b90508060025f8473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f20600501819055508173ffffffffffffffffffffffffffffffffffffffff167ffc577563f1b9a0461e24abef1e1fcc0d33d3d881f20b5df6dda59de4aae2c82182604051610d6491906119fa565b60405180910390a250508080600101915050610bf2565b506001905090565b5f5f60025f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205f018054610dcf906121d6565b905014610e11576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610e089061254b565b60405180910390fd5b5f865103610e54576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610e4b906125b3565b60405180910390fd5b6040518060c001604052808781526020018681526020018581526020018481526020018381526020015f5f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166327c06fd5336040518263ffffffff1660e01b8152600401610ed69190611f9b565b602060405180830381865afa158015610ef1573d5f5f3e3d5ffd5b505050506040513d601f19601f82011682018060405250810190610f159190611fc8565b81525060025f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205f820151815f019081610f689190612432565b506020820151816001019081610f7e9190612432565b506040820151816002019081610f949190612432565b506060820151816003019081610faa9190612432565b506080820151816004019081610fc09190612432565b5060a08201518160050155905050600333908060018154018082558091505060019003905f5260205f20015f9091909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055503373ffffffffffffffffffffffffffffffffffffffff167fa9f13e94f3f7dbf69ac8405e3aa6f43a6f162984687d099c7a5cd9b602552cc260405160405180910390a26001905095945050505050565b60608060608060605f5f60025f8973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f206040518060c00160405290815f820180546110df906121d6565b80601f016020809104026020016040519081016040528092919081815260200182805461110b906121d6565b80156111565780601f1061112d57610100808354040283529160200191611156565b820191905f5260205f20905b81548152906001019060200180831161113957829003601f168201915b5050505050815260200160018201805461116f906121d6565b80601f016020809104026020016040519081016040528092919081815260200182805461119b906121d6565b80156111e65780601f106111bd576101008083540402835291602001916111e6565b820191905f5260205f20905b8154815290600101906020018083116111c957829003601f168201915b505050505081526020016002820180546111ff906121d6565b80601f016020809104026020016040519081016040528092919081815260200182805461122b906121d6565b80156112765780601f1061124d57610100808354040283529160200191611276565b820191905f5260205f20905b81548152906001019060200180831161125957829003601f168201915b5050505050815260200160038201805461128f906121d6565b80601f01602080910402602001604051908101604052809291908181526020018280546112bb906121d6565b80156113065780601f106112dd57610100808354040283529160200191611306565b820191905f5260205f20905b8154815290600101906020018083116112e957829003601f168201915b5050505050815260200160048201805461131f906121d6565b80601f016020809104026020016040519081016040528092919081815260200182805461134b906121d6565b80156113965780601f1061136d57610100808354040283529160200191611396565b820191905f5260205f20905b81548152906001019060200180831161137957829003601f168201915b505050505081526020016005820154815250509050805f015181602001518260400151836060015184608001518560a001519650965096509650965096505091939550919395565b60605f60038054905067ffffffffffffffff811115611400576113ff611b9d565b5b60405190808252806020026020018201604052801561142e5781602001602082028036833780820191505090505b5090505f5f90505f5f90505b60038054905081101561156e578460025f6003848154811061145f5761145e6120ee565b5b905f5260205f20015f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f20600501541061156157600381815481106114dd576114dc6120ee565b5b905f5260205f20015f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff16838381518110611518576115176120ee565b5b602002602001019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff1681525050818061155d906125d1565b9250505b808060010191505061143a565b505f8167ffffffffffffffff81111561158a57611589611b9d565b5b6040519080825280602002602001820160405280156115b85781602001602082028036833780820191505090505b5090505f5f90505b8281101561163d578381815181106115db576115da6120ee565b5b60200260200101518282815181106115f6576115f56120ee565b5b602002602001019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff168152505080806001019150506115c0565b50809350505050919050565b60605f60038054905067ffffffffffffffff81111561166b5761166a611b9d565b5b6040519080825280602002602001820160405280156116995781602001602082028036833780820191505090505b5090505f5f90505f5f90505b6003805490508110156117f457848051906020012060025f600384815481106116d1576116d06120ee565b5b905f5260205f20015f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f2060040160405161174291906126b4565b6040518091039020036117e75760038181548110611763576117626120ee565b5b905f5260205f20015f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1683838151811061179e5761179d6120ee565b5b602002602001019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff168152505081806117e3906125d1565b9250505b80806001019150506116a5565b505f8167ffffffffffffffff8111156118105761180f611b9d565b5b60405190808252806020026020018201604052801561183e5781602001602082028036833780820191505090505b5090505f5f90505b828110156118c357838181518110611861576118606120ee565b5b602002602001015182828151811061187c5761187b6120ee565b5b602002602001019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff16815250508080600101915050611846565b50809350505050919050565b60015f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b508054611900906121d6565b5f825580601f10611911575061192e565b601f0160209004905f5260205f209081019061192d9190611931565b5b50565b5b80821115611948575f815f905550600101611932565b5090565b5f604051905090565b5f5ffd5b5f5ffd5b5f73ffffffffffffffffffffffffffffffffffffffff82169050919050565b5f6119868261195d565b9050919050565b6119968161197c565b81146119a0575f5ffd5b50565b5f813590506119b18161198d565b92915050565b5f602082840312156119cc576119cb611955565b5b5f6119d9848285016119a3565b91505092915050565b5f819050919050565b6119f4816119e2565b82525050565b5f602082019050611a0d5f8301846119eb565b92915050565b611a1c816119e2565b8114611a26575f5ffd5b50565b5f81359050611a3781611a13565b92915050565b5f5f60408385031215611a5357611a52611955565b5b5f611a6085828601611a29565b9250506020611a7185828601611a29565b9150509250929050565b5f81519050919050565b5f82825260208201905092915050565b5f819050602082019050919050565b611aad8161197c565b82525050565b5f611abe8383611aa4565b60208301905092915050565b5f602082019050919050565b5f611ae082611a7b565b611aea8185611a85565b9350611af583611a95565b805f5b83811015611b25578151611b0c8882611ab3565b9750611b1783611aca565b925050600181019050611af8565b5085935050505092915050565b5f6020820190508181035f830152611b4a8184611ad6565b905092915050565b5f8115159050919050565b611b6681611b52565b82525050565b5f602082019050611b7f5f830184611b5d565b92915050565b5f5ffd5b5f5ffd5b5f601f19601f8301169050919050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52604160045260245ffd5b611bd382611b8d565b810181811067ffffffffffffffff82111715611bf257611bf1611b9d565b5b80604052505050565b5f611c0461194c565b9050611c108282611bca565b919050565b5f67ffffffffffffffff821115611c2f57611c2e611b9d565b5b611c3882611b8d565b9050602081019050919050565b828183375f83830152505050565b5f611c65611c6084611c15565b611bfb565b905082815260208101848484011115611c8157611c80611b89565b5b611c8c848285611c45565b509392505050565b5f82601f830112611ca857611ca7611b85565b5b8135611cb8848260208601611c53565b91505092915050565b5f5f5f5f5f60a08688031215611cda57611cd9611955565b5b5f86013567ffffffffffffffff811115611cf757611cf6611959565b5b611d0388828901611c94565b955050602086013567ffffffffffffffff811115611d2457611d23611959565b5b611d3088828901611c94565b945050604086013567ffffffffffffffff811115611d5157611d50611959565b5b611d5d88828901611c94565b935050606086013567ffffffffffffffff811115611d7e57611d7d611959565b5b611d8a88828901611c94565b925050608086013567ffffffffffffffff811115611dab57611daa611959565b5b611db788828901611c94565b9150509295509295909350565b5f819050919050565b5f611de7611de2611ddd8461195d565b611dc4565b61195d565b9050919050565b5f611df882611dcd565b9050919050565b5f611e0982611dee565b9050919050565b611e1981611dff565b82525050565b5f602082019050611e325f830184611e10565b92915050565b5f81519050919050565b5f82825260208201905092915050565b8281835e5f83830152505050565b5f611e6a82611e38565b611e748185611e42565b9350611e84818560208601611e52565b611e8d81611b8d565b840191505092915050565b5f60c0820190508181035f830152611eb08189611e60565b90508181036020830152611ec48188611e60565b90508181036040830152611ed88187611e60565b90508181036060830152611eec8186611e60565b90508181036080830152611f008185611e60565b9050611f0f60a08301846119eb565b979650505050505050565b5f60208284031215611f2f57611f2e611955565b5b5f611f3c84828501611a29565b91505092915050565b5f60208284031215611f5a57611f59611955565b5b5f82013567ffffffffffffffff811115611f7757611f76611959565b5b611f8384828501611c94565b91505092915050565b611f958161197c565b82525050565b5f602082019050611fae5f830184611f8c565b92915050565b5f81519050611fc281611a13565b92915050565b5f60208284031215611fdd57611fdc611955565b5b5f611fea84828501611fb4565b91505092915050565b7f496e697469616c20696e646578206f7574206f66206c696d69740000000000005f82015250565b5f612027601a83611e42565b915061203282611ff3565b602082019050919050565b5f6020820190508181035f8301526120548161201b565b9050919050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52601160045260245ffd5b5f612092826119e2565b915061209d836119e2565b92508282019050808211156120b5576120b461205b565b5b92915050565b5f6120c5826119e2565b91506120d0836119e2565b92508282039050818111156120e8576120e761205b565b5b92915050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52603260045260245ffd5b7f4f6e6c792061646d696e2063616e20706572666f726d207468697320616374695f8201527f6f6e000000000000000000000000000000000000000000000000000000000000602082015250565b5f612175602283611e42565b91506121808261211b565b604082019050919050565b5f6020820190508181035f8301526121a281612169565b9050919050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52602260045260245ffd5b5f60028204905060018216806121ed57607f821691505b602082108103612200576121ff6121a9565b5b50919050565b7f537570706c696572206e6f7420666f756e6400000000000000000000000000005f82015250565b5f61223a601283611e42565b915061224582612206565b602082019050919050565b5f6020820190508181035f8301526122678161222e565b9050919050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52603160045260245ffd5b5f819050815f5260205f209050919050565b5f6020601f8301049050919050565b5f82821b905092915050565b5f600883026122f77fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff826122bc565b61230186836122bc565b95508019841693508086168417925050509392505050565b5f61233361232e612329846119e2565b611dc4565b6119e2565b9050919050565b5f819050919050565b61234c83612319565b6123606123588261233a565b8484546122c8565b825550505050565b5f5f905090565b612377612368565b612382818484612343565b505050565b5b818110156123a55761239a5f8261236f565b600181019050612388565b5050565b601f8211156123ea576123bb8161229b565b6123c4846122ad565b810160208510156123d3578190505b6123e76123df856122ad565b830182612387565b50505b505050565b5f82821c905092915050565b5f61240a5f19846008026123ef565b1980831691505092915050565b5f61242283836123fb565b9150826002028217905092915050565b61243b82611e38565b67ffffffffffffffff81111561245457612453611b9d565b5b61245e82546121d6565b6124698282856123a9565b5f60209050601f83116001811461249a575f8415612488578287015190505b6124928582612417565b8655506124f9565b601f1984166124a88661229b565b5f5b828110156124cf578489015182556001820191506020850194506020810190506124aa565b868310156124ec57848901516124e8601f8916826123fb565b8355505b6001600288020188555050505b505050505050565b7f537570706c69657220616c7265616479206578697374730000000000000000005f82015250565b5f612535601783611e42565b915061254082612501565b602082019050919050565b5f6020820190508181035f83015261256281612529565b9050919050565b7f4e616d65206973207265717569726564000000000000000000000000000000005f82015250565b5f61259d601083611e42565b91506125a882612569565b602082019050919050565b5f6020820190508181035f8301526125ca81612591565b9050919050565b5f6125db826119e2565b91507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff820361260d5761260c61205b565b5b600182019050919050565b5f81905092915050565b5f819050815f5260205f209050919050565b5f8154612640816121d6565b61264a8186612618565b9450600182165f81146126645760018114612679576126ab565b60ff19831686528115158202860193506126ab565b61268285612622565b5f5b838110156126a357815481890152600182019150602081019050612684565b838801955050505b50505092915050565b5f6126bf8284612634565b91508190509291505056fea264697066735822122067e0472f54738e9af2905948607d537b94c5f8beda79b26a909ea44dad7bea2b64736f6c634300081e0033";

    private static String librariesLinkedBinary;

    public static final String FUNC_ADDSUPPLIER = "addSupplier";

    public static final String FUNC_ADMIN = "admin";

    public static final String FUNC_ALLSUPPLIERS = "allSuppliers";

    public static final String FUNC_CHECKREPUTATION = "checkReputation";

    public static final String FUNC_FILTERBYGOODSTYPE = "filterByGoodsType";

    public static final String FUNC_FILTEREDBYREPUTATION = "filteredByReputation";

    public static final String FUNC_FINDSUPPLIER = "findSupplier";

    public static final String FUNC_GETSUPPLIERCOUNT = "getSupplierCount";

    public static final String FUNC_GETSUPPLIERPAGINATED = "getSupplierPaginated";

    public static final String FUNC_REMOVESUPPLIER = "removeSupplier";

    public static final String FUNC_TRACK = "track";

    public static final String FUNC_UPDATEREPUTATIONS = "updateReputations";

    public static final String FUNC_UPDATESUPPLIERINFO = "updateSupplierInfo";

    public static final Event REPUTATIONUPDATED_EVENT = new Event("ReputationUpdated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event SUPPLIERADDED_EVENT = new Event("SupplierAdded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event SUPPLIERREMOVED_EVENT = new Event("SupplierRemoved", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    @Deprecated
    protected TrustLedger(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected TrustLedger(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected TrustLedger(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected TrustLedger(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<ReputationUpdatedEventResponse> getReputationUpdatedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(REPUTATIONUPDATED_EVENT, transactionReceipt);
        ArrayList<ReputationUpdatedEventResponse> responses = new ArrayList<ReputationUpdatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ReputationUpdatedEventResponse typedResponse = new ReputationUpdatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.supplier = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newReputation = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static ReputationUpdatedEventResponse getReputationUpdatedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(REPUTATIONUPDATED_EVENT, log);
        ReputationUpdatedEventResponse typedResponse = new ReputationUpdatedEventResponse();
        typedResponse.log = log;
        typedResponse.supplier = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.newReputation = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<ReputationUpdatedEventResponse> reputationUpdatedEventFlowable(
            EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getReputationUpdatedEventFromLog(log));
    }

    public Flowable<ReputationUpdatedEventResponse> reputationUpdatedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(REPUTATIONUPDATED_EVENT));
        return reputationUpdatedEventFlowable(filter);
    }

    public static List<SupplierAddedEventResponse> getSupplierAddedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(SUPPLIERADDED_EVENT, transactionReceipt);
        ArrayList<SupplierAddedEventResponse> responses = new ArrayList<SupplierAddedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SupplierAddedEventResponse typedResponse = new SupplierAddedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.supplier = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static SupplierAddedEventResponse getSupplierAddedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(SUPPLIERADDED_EVENT, log);
        SupplierAddedEventResponse typedResponse = new SupplierAddedEventResponse();
        typedResponse.log = log;
        typedResponse.supplier = (String) eventValues.getIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<SupplierAddedEventResponse> supplierAddedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getSupplierAddedEventFromLog(log));
    }

    public Flowable<SupplierAddedEventResponse> supplierAddedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SUPPLIERADDED_EVENT));
        return supplierAddedEventFlowable(filter);
    }

    public static List<SupplierRemovedEventResponse> getSupplierRemovedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(SUPPLIERREMOVED_EVENT, transactionReceipt);
        ArrayList<SupplierRemovedEventResponse> responses = new ArrayList<SupplierRemovedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SupplierRemovedEventResponse typedResponse = new SupplierRemovedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.supplier = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static SupplierRemovedEventResponse getSupplierRemovedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(SUPPLIERREMOVED_EVENT, log);
        SupplierRemovedEventResponse typedResponse = new SupplierRemovedEventResponse();
        typedResponse.log = log;
        typedResponse.supplier = (String) eventValues.getIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<SupplierRemovedEventResponse> supplierRemovedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getSupplierRemovedEventFromLog(log));
    }

    public Flowable<SupplierRemovedEventResponse> supplierRemovedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SUPPLIERREMOVED_EVENT));
        return supplierRemovedEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> addSupplier(String _name, String _phoneNo,
            String _cityState, String _country, String _goodsType) {
        final Function function = new Function(
                FUNC_ADDSUPPLIER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_phoneNo), 
                new org.web3j.abi.datatypes.Utf8String(_cityState), 
                new org.web3j.abi.datatypes.Utf8String(_country), 
                new org.web3j.abi.datatypes.Utf8String(_goodsType)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> admin() {
        final Function function = new Function(FUNC_ADMIN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<List> allSuppliers() {
        final Function function = new Function(FUNC_ALLSUPPLIERS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> checkReputation(String _supplier) {
        final Function function = new Function(FUNC_CHECKREPUTATION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _supplier)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<List> filterByGoodsType(String _goodsType) {
        final Function function = new Function(FUNC_FILTERBYGOODSTYPE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_goodsType)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<List> filteredByReputation(BigInteger _reputation) {
        final Function function = new Function(FUNC_FILTEREDBYREPUTATION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_reputation)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<Tuple6<String, String, String, String, String, BigInteger>> findSupplier(
            String _supplier) {
        final Function function = new Function(FUNC_FINDSUPPLIER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _supplier)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple6<String, String, String, String, String, BigInteger>>(function,
                new Callable<Tuple6<String, String, String, String, String, BigInteger>>() {
                    @Override
                    public Tuple6<String, String, String, String, String, BigInteger> call() throws
                            Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple6<String, String, String, String, String, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (String) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue());
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> getSupplierCount() {
        final Function function = new Function(FUNC_GETSUPPLIERCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<List> getSupplierPaginated(BigInteger start, BigInteger limit) {
        final Function function = new Function(FUNC_GETSUPPLIERPAGINATED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(start), 
                new org.web3j.abi.datatypes.generated.Uint256(limit)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> removeSupplier(String _supplier) {
        final Function function = new Function(
                FUNC_REMOVESUPPLIER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _supplier)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> track() {
        final Function function = new Function(FUNC_TRACK, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> updateReputations() {
        final Function function = new Function(
                FUNC_UPDATEREPUTATIONS, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> updateSupplierInfo(String _name, String _phoneNo,
            String _cityState, String _country, String _goodsType) {
        final Function function = new Function(
                FUNC_UPDATESUPPLIERINFO, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_phoneNo), 
                new org.web3j.abi.datatypes.Utf8String(_cityState), 
                new org.web3j.abi.datatypes.Utf8String(_country), 
                new org.web3j.abi.datatypes.Utf8String(_goodsType)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static TrustLedger load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new TrustLedger(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static TrustLedger load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TrustLedger(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static TrustLedger load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new TrustLedger(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static TrustLedger load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new TrustLedger(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<TrustLedger> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider, String _trackingAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _trackingAddress)));
        return deployRemoteCall(TrustLedger.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    public static RemoteCall<TrustLedger> deploy(Web3j web3j, TransactionManager transactionManager,
            ContractGasProvider contractGasProvider, String _trackingAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _trackingAddress)));
        return deployRemoteCall(TrustLedger.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<TrustLedger> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit, String _trackingAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _trackingAddress)));
        return deployRemoteCall(TrustLedger.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<TrustLedger> deploy(Web3j web3j, TransactionManager transactionManager,
            BigInteger gasPrice, BigInteger gasLimit, String _trackingAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _trackingAddress)));
        return deployRemoteCall(TrustLedger.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
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

    public static class ReputationUpdatedEventResponse extends BaseEventResponse {
        public String supplier;

        public BigInteger newReputation;
    }

    public static class SupplierAddedEventResponse extends BaseEventResponse {
        public String supplier;
    }

    public static class SupplierRemovedEventResponse extends BaseEventResponse {
        public String supplier;
    }
}
