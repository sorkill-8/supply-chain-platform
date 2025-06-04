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
import org.web3j.abi.datatypes.Array;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
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
public class Tracking extends Contract {
    public static final String BINARY = "608060405234801561000f575f5ffd5b506040516125b93803806125b98339818101604052810190610031919061010f565b335f5f6101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508060055f5f5f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f20819055505061013a565b5f5ffd5b5f819050919050565b6100ee816100dc565b81146100f8575f5ffd5b50565b5f81519050610109816100e5565b92915050565b5f60208284031215610124576101236100d8565b5b5f610131848285016100fb565b91505092915050565b612472806101475f395ff3fe608060405234801561000f575f5ffd5b506004361061009c575f3560e01c8063826e2e5111610064578063826e2e5114610191578063b29a8140146101c1578063c71bd24c146101f1578063e79bc33b14610221578063f8b2cb4f146102565761009c565b806327c06fd5146100a05780632fdcfbd2146100d057806331742fa71461010057806356992fe2146101315780635f176b5914610161575b5f5ffd5b6100ba60048036038101906100b59190611267565b610286565b6040516100c791906112aa565b60405180910390f35b6100ea60048036038101906100e591906112ed565b61036d565b6040516100f79190611357565b60405180910390f35b61011a60048036038101906101159190611267565b6104da565b604051610128929190611370565b60405180910390f35b61014b600480360381019061014691906114d3565b610561565b6040516101589190611357565b60405180910390f35b61017b600480360381019061017691906115de565b61067f565b6040516101889190611357565b60405180910390f35b6101ab60048036038101906101a6919061164a565b61073e565b6040516101b89190611357565b60405180910390f35b6101db60048036038101906101d69190611702565b610afc565b6040516101e89190611357565b60405180910390f35b61020b6004803603810190610206919061164a565b610d36565b6040516102189190611357565b60405180910390f35b61023b600480360381019061023691906114d3565b610f05565b60405161024d969594939291906118d9565b60405180910390f35b610270600480360381019061026b9190611267565b6110f5565b60405161027d91906112aa565b60405180910390f35b5f5f60065f8473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f2054146103645760065f8373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205460075f8473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205460646103539190611973565b61035d91906119e1565b9050610368565b5f90505b919050565b5f8160055f8673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205410156103ee576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016103e590611a5b565b60405180910390fd5b8160055f8673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205f82825461043a9190611a79565b925050819055508160055f8573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205f82825461048d9190611aac565b925050819055507f26eb4a415baf730c62c6011b03653f5b8960baf7ad391bd18725e6caa4bfa4c98484846040516104c793929190611b29565b60405180910390a1600190509392505050565b5f5f60075f8473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205460065f8573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205491509150915091565b5f5f5f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146105f0576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016105e790611be1565b60405180910390fd5b6004826040516106009190611c39565b90815260200160405180910390205f5f82015f61061d919061113b565b600182015f9055600282015f6106339190611178565b600382015f9055600482015f6101000a81549073ffffffffffffffffffffffffffffffffffffffff02191690556004820160146101000a81549060ff0219169055505060019050919050565b5f5f5f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461070e576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161070590611be1565b60405180910390fd5b8360019080519060200190610724929190611196565b508260028190555081600381905550600190509392505050565b5f5f6004866040516107509190611c39565b908152602001604051809103902090505f73ffffffffffffffffffffffffffffffffffffffff16816004015f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16036107f1576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016107e890611c99565b60405180910390fd5b5f600281111561080457610803611866565b5b8160040160149054906101000a900460ff16600281111561082857610827611866565b5b14610868576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161085f90611d27565b60405180910390fd5b8480519060200120815f016040516108809190611e3e565b60405180910390201480156108985750838160010154145b6108d7576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016108ce90611e9e565b60405180910390fd5b60018160040160146101000a81548160ff021916908360028111156108ff576108fe611866565b5b0217905550600160075f836004015f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205f8282546109749190611aac565b925050819055507f6d5fd9f24176dbb1bcb1e48cb31e1bbd5f7a6cc07a00d0d9ad19c0a313349411868442336040516109b09493929190611f06565b60405180910390a160025481600301546109ca9190611aac565b42111580156109db57506002835110155b8015610a1c575060015f815481106109f6576109f5611f6a565b5b905f5260205f200154835f81518110610a1257610a11611f6a565b5b6020026020010151145b8015610a5e575060018081548110610a3757610a36611f6a565b5b905f5260205f20015483600181518110610a5457610a53611f6a565b5b6020026020010151145b15610ab957610ab35f5f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff16826004015f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1660035461036d565b50610aef565b7ffd5de27667e5407df5be0b6efb7f86ae8c40433040399a5e4d36a46ccc50638d604051610ae690612007565b60405180910390a15b6001915050949350505050565b5f5f5f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610b8b576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610b8290611be1565b60405180910390fd5b8160055f8573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f20541015610c0b576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610c029061206f565b60405180910390fd5b8160055f8573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205f828254610c579190611a79565b925050819055508160055f5f5f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205f828254610cca9190611aac565b925050819055507f26eb4a415baf730c62c6011b03653f5b8960baf7ad391bd18725e6caa4bfa4c9835f5f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1684604051610d24939291906120d7565b60405180910390a16001905092915050565b5f6040518060c001604052808581526020018481526020018381526020014281526020013373ffffffffffffffffffffffffffffffffffffffff1681526020015f6002811115610d8957610d88611866565b5b815250600486604051610d9c9190611c39565b90815260200160405180910390205f820151815f019081610dbd91906122bf565b50602082015181600101556040820151816002019080519060200190610de4929190611196565b50606082015181600301556080820151816004015f6101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060a08201518160040160146101000a81548160ff02191690836002811115610e6057610e5f611866565b5b0217905550905050600160065f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205f828254610eb59190611aac565b925050819055507f6d5fd9f24176dbb1bcb1e48cb31e1bbd5f7a6cc07a00d0d9ad19c0a31334941185834233604051610ef194939291906123d8565b60405180910390a160019050949350505050565b60605f60605f5f5f5f600488604051610f1e9190611c39565b90815260200160405180910390206040518060c00160405290815f82018054610f4690611d72565b80601f0160208091040260200160405190810160405280929190818152602001828054610f7290611d72565b8015610fbd5780601f10610f9457610100808354040283529160200191610fbd565b820191905f5260205f20905b815481529060010190602001808311610fa057829003601f168201915b50505050508152602001600182015481526020016002820180548060200260200160405190810160405280929190818152602001828054801561101d57602002820191905f5260205f20905b815481526020019060010190808311611009575b5050505050815260200160038201548152602001600482015f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020016004820160149054906101000a900460ff1660028111156110aa576110a9611866565b5b60028111156110bc576110bb611866565b5b815250509050805f015181602001518260400151836060015184608001518560a001519650965096509650965096505091939550919395565b5f60055f8373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f20549050919050565b50805461114790611d72565b5f825580601f106111585750611175565b601f0160209004905f5260205f209081019061117491906111e1565b5b50565b5080545f8255905f5260205f209081019061119391906111e1565b50565b828054828255905f5260205f209081019282156111d0579160200282015b828111156111cf5782518255916020019190600101906111b4565b5b5090506111dd91906111e1565b5090565b5b808211156111f8575f815f9055506001016111e2565b5090565b5f604051905090565b5f5ffd5b5f5ffd5b5f73ffffffffffffffffffffffffffffffffffffffff82169050919050565b5f6112368261120d565b9050919050565b6112468161122c565b8114611250575f5ffd5b50565b5f813590506112618161123d565b92915050565b5f6020828403121561127c5761127b611205565b5b5f61128984828501611253565b91505092915050565b5f819050919050565b6112a481611292565b82525050565b5f6020820190506112bd5f83018461129b565b92915050565b6112cc81611292565b81146112d6575f5ffd5b50565b5f813590506112e7816112c3565b92915050565b5f5f5f6060848603121561130457611303611205565b5b5f61131186828701611253565b935050602061132286828701611253565b9250506040611333868287016112d9565b9150509250925092565b5f8115159050919050565b6113518161133d565b82525050565b5f60208201905061136a5f830184611348565b92915050565b5f6040820190506113835f83018561129b565b611390602083018461129b565b9392505050565b5f5ffd5b5f5ffd5b5f601f19601f8301169050919050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52604160045260245ffd5b6113e58261139f565b810181811067ffffffffffffffff82111715611404576114036113af565b5b80604052505050565b5f6114166111fc565b905061142282826113dc565b919050565b5f67ffffffffffffffff821115611441576114406113af565b5b61144a8261139f565b9050602081019050919050565b828183375f83830152505050565b5f61147761147284611427565b61140d565b9050828152602081018484840111156114935761149261139b565b5b61149e848285611457565b509392505050565b5f82601f8301126114ba576114b9611397565b5b81356114ca848260208601611465565b91505092915050565b5f602082840312156114e8576114e7611205565b5b5f82013567ffffffffffffffff81111561150557611504611209565b5b611511848285016114a6565b91505092915050565b5f67ffffffffffffffff821115611534576115336113af565b5b602082029050602081019050919050565b5f5ffd5b5f61155b6115568461151a565b61140d565b9050808382526020820190506020840283018581111561157e5761157d611545565b5b835b818110156115a7578061159388826112d9565b845260208401935050602081019050611580565b5050509392505050565b5f82601f8301126115c5576115c4611397565b5b81356115d5848260208601611549565b91505092915050565b5f5f5f606084860312156115f5576115f4611205565b5b5f84013567ffffffffffffffff81111561161257611611611209565b5b61161e868287016115b1565b935050602061162f868287016112d9565b9250506040611640868287016112d9565b9150509250925092565b5f5f5f5f6080858703121561166257611661611205565b5b5f85013567ffffffffffffffff81111561167f5761167e611209565b5b61168b878288016114a6565b945050602085013567ffffffffffffffff8111156116ac576116ab611209565b5b6116b8878288016114a6565b93505060406116c9878288016112d9565b925050606085013567ffffffffffffffff8111156116ea576116e9611209565b5b6116f6878288016115b1565b91505092959194509250565b5f5f6040838503121561171857611717611205565b5b5f61172585828601611253565b9250506020611736858286016112d9565b9150509250929050565b5f81519050919050565b5f82825260208201905092915050565b8281835e5f83830152505050565b5f61177282611740565b61177c818561174a565b935061178c81856020860161175a565b6117958161139f565b840191505092915050565b5f81519050919050565b5f82825260208201905092915050565b5f819050602082019050919050565b6117d281611292565b82525050565b5f6117e383836117c9565b60208301905092915050565b5f602082019050919050565b5f611805826117a0565b61180f81856117aa565b935061181a836117ba565b805f5b8381101561184a57815161183188826117d8565b975061183c836117ef565b92505060018101905061181d565b5085935050505092915050565b6118608161122c565b82525050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52602160045260245ffd5b600381106118a4576118a3611866565b5b50565b5f8190506118b482611893565b919050565b5f6118c3826118a7565b9050919050565b6118d3816118b9565b82525050565b5f60c0820190508181035f8301526118f18189611768565b9050611900602083018861129b565b818103604083015261191281876117fb565b9050611921606083018661129b565b61192e6080830185611857565b61193b60a08301846118ca565b979650505050505050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52601160045260245ffd5b5f61197d82611292565b915061198883611292565b925082820261199681611292565b915082820484148315176119ad576119ac611946565b5b5092915050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52601260045260245ffd5b5f6119eb82611292565b91506119f683611292565b925082611a0657611a056119b4565b5b828204905092915050565b7f496e73756666696369656e742066756e647300000000000000000000000000005f82015250565b5f611a4560128361174a565b9150611a5082611a11565b602082019050919050565b5f6020820190508181035f830152611a7281611a39565b9050919050565b5f611a8382611292565b9150611a8e83611292565b9250828203905081811115611aa657611aa5611946565b5b92915050565b5f611ab682611292565b9150611ac183611292565b9250828201905080821115611ad957611ad8611946565b5b92915050565b7f5061796d656e742073656e7400000000000000000000000000000000000000005f82015250565b5f611b13600c8361174a565b9150611b1e82611adf565b602082019050919050565b5f6080820190508181035f830152611b4081611b07565b9050611b4f6020830186611857565b611b5c6040830185611857565b611b69606083018461129b565b949350505050565b7f4f6e6c792061646d696e2063616e20706572666f726d207468697320616374695f8201527f6f6e000000000000000000000000000000000000000000000000000000000000602082015250565b5f611bcb60228361174a565b9150611bd682611b71565b604082019050919050565b5f6020820190508181035f830152611bf881611bbf565b9050919050565b5f81905092915050565b5f611c1382611740565b611c1d8185611bff565b9350611c2d81856020860161175a565b80840191505092915050565b5f611c448284611c09565b915081905092915050565b7f536869706d656e74206e6f7420666f756e6400000000000000000000000000005f82015250565b5f611c8360128361174a565b9150611c8e82611c4f565b602082019050919050565b5f6020820190508181035f830152611cb081611c77565b9050919050565b7f536869706d656e7420616c72656164792064656c697665726564206f722063615f8201527f6e63656c6c656400000000000000000000000000000000000000000000000000602082015250565b5f611d1160278361174a565b9150611d1c82611cb7565b604082019050919050565b5f6020820190508181035f830152611d3e81611d05565b9050919050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52602260045260245ffd5b5f6002820490506001821680611d8957607f821691505b602082108103611d9c57611d9b611d45565b5b50919050565b5f81905092915050565b5f819050815f5260205f209050919050565b5f8154611dca81611d72565b611dd48186611da2565b9450600182165f8114611dee5760018114611e0357611e35565b60ff1983168652811515820286019350611e35565b611e0c85611dac565b5f5b83811015611e2d57815481890152600182019150602081019050611e0e565b838801955050505b50505092915050565b5f611e498284611dbe565b915081905092915050565b7f4974656d206f72207175616e74697479206d69736d61746368000000000000005f82015250565b5f611e8860198361174a565b9150611e9382611e54565b602082019050919050565b5f6020820190508181035f830152611eb581611e7c565b9050919050565b7f4974656d207265636569766564000000000000000000000000000000000000005f82015250565b5f611ef0600d8361174a565b9150611efb82611ebc565b602082019050919050565b5f60a0820190508181035f830152611f1d81611ee4565b90508181036020830152611f318187611768565b90508181036040830152611f4581866117fb565b9050611f54606083018561129b565b611f616080830184611857565b95945050505050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52603260045260245ffd5b7f5061796d656e74206e6f74207472696767657265643a206372697465726961205f8201527f6e6f74206d657400000000000000000000000000000000000000000000000000602082015250565b5f611ff160278361174a565b9150611ffc82611f97565b604082019050919050565b5f6020820190508181035f83015261201e81611fe5565b9050919050565b7f496e73756666696369656e742066756e647320666f72207265636f76657279005f82015250565b5f612059601f8361174a565b915061206482612025565b602082019050919050565b5f6020820190508181035f8301526120868161204d565b9050919050565b7f46756e6473207265636f766572656400000000000000000000000000000000005f82015250565b5f6120c1600f8361174a565b91506120cc8261208d565b602082019050919050565b5f6080820190508181035f8301526120ee816120b5565b90506120fd6020830186611857565b61210a6040830185611857565b612117606083018461129b565b949350505050565b5f819050815f5260205f209050919050565b5f6020601f8301049050919050565b5f82821b905092915050565b5f6008830261217b7fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff82612140565b6121858683612140565b95508019841693508086168417925050509392505050565b5f819050919050565b5f6121c06121bb6121b684611292565b61219d565b611292565b9050919050565b5f819050919050565b6121d9836121a6565b6121ed6121e5826121c7565b84845461214c565b825550505050565b5f5f905090565b6122046121f5565b61220f8184846121d0565b505050565b5b81811015612232576122275f826121fc565b600181019050612215565b5050565b601f821115612277576122488161211f565b61225184612131565b81016020851015612260578190505b61227461226c85612131565b830182612214565b50505b505050565b5f82821c905092915050565b5f6122975f198460080261227c565b1980831691505092915050565b5f6122af8383612288565b9150826002028217905092915050565b6122c882611740565b67ffffffffffffffff8111156122e1576122e06113af565b5b6122eb8254611d72565b6122f6828285612236565b5f60209050601f831160018114612327575f8415612315578287015190505b61231f85826122a4565b865550612386565b601f1984166123358661211f565b5f5b8281101561235c57848901518255600182019150602085019450602081019050612337565b868310156123795784890151612375601f891682612288565b8355505b6001600288020188555050505b505050505050565b7f4974656d207368697070656400000000000000000000000000000000000000005f82015250565b5f6123c2600c8361174a565b91506123cd8261238e565b602082019050919050565b5f60a0820190508181035f8301526123ef816123b6565b905081810360208301526124038187611768565b9050818103604083015261241781866117fb565b9050612426606083018561129b565b6124336080830184611857565b9594505050505056fea2646970667358221220e9f72f2c2c734b436482e31b3210f187360251fe8509b217bc8f8d91d628b57964736f6c634300081e0033";

    private static String librariesLinkedBinary;

    public static final String FUNC_CALCULATEREPUTATION = "calculateReputation";

    public static final String FUNC_CHECKSHIPMENT = "checkShipment";

    public static final String FUNC_CHECKSUCCESS = "checkSuccess";

    public static final String FUNC_DELETESHIPMENT = "deleteShipment";

    public static final String FUNC_GETBALANCE = "getBalance";

    public static final String FUNC_RECEIVESHIPMENT = "receiveShipment";

    public static final String FUNC_RECOVERTOKEN = "recoverToken";

    public static final String FUNC_SENDSHIPMENT = "sendShipment";

    public static final String FUNC_SENDTOKEN = "sendToken";

    public static final String FUNC_SETCONTRACTPARAMETERS = "setContractParameters";

    public static final Event FAILURE_EVENT = new Event("Failure", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
    ;

    public static final Event PAYMENT_EVENT = new Event("Payment", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event SUCCESS_EVENT = new Event("Success", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
    ;

    @Deprecated
    protected Tracking(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Tracking(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Tracking(String contractAddress, Web3j web3j, TransactionManager transactionManager,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Tracking(String contractAddress, Web3j web3j, TransactionManager transactionManager,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<FailureEventResponse> getFailureEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(FAILURE_EVENT, transactionReceipt);
        ArrayList<FailureEventResponse> responses = new ArrayList<FailureEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            FailureEventResponse typedResponse = new FailureEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._message = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static FailureEventResponse getFailureEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(FAILURE_EVENT, log);
        FailureEventResponse typedResponse = new FailureEventResponse();
        typedResponse.log = log;
        typedResponse._message = (String) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<FailureEventResponse> failureEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getFailureEventFromLog(log));
    }

    public Flowable<FailureEventResponse> failureEventFlowable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(FAILURE_EVENT));
        return failureEventFlowable(filter);
    }

    public static List<PaymentEventResponse> getPaymentEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(PAYMENT_EVENT, transactionReceipt);
        ArrayList<PaymentEventResponse> responses = new ArrayList<PaymentEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            PaymentEventResponse typedResponse = new PaymentEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._message = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._from = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse._to = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse._amount = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static PaymentEventResponse getPaymentEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(PAYMENT_EVENT, log);
        PaymentEventResponse typedResponse = new PaymentEventResponse();
        typedResponse.log = log;
        typedResponse._message = (String) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse._from = (String) eventValues.getNonIndexedValues().get(1).getValue();
        typedResponse._to = (String) eventValues.getNonIndexedValues().get(2).getValue();
        typedResponse._amount = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
        return typedResponse;
    }

    public Flowable<PaymentEventResponse> paymentEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getPaymentEventFromLog(log));
    }

    public Flowable<PaymentEventResponse> paymentEventFlowable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PAYMENT_EVENT));
        return paymentEventFlowable(filter);
    }

    @SuppressWarnings("unchecked")
	public static List<SuccessEventResponse> getSuccessEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(SUCCESS_EVENT, transactionReceipt);
        ArrayList<SuccessEventResponse> responses = new ArrayList<SuccessEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SuccessEventResponse typedResponse = new SuccessEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._message = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.trackingNo = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse._locationData = (List<BigInteger>) ((Array) eventValues.getNonIndexedValues().get(2)).getNativeValueCopy();
            typedResponse._timeStamp = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse._sender = (String) eventValues.getNonIndexedValues().get(4).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    @SuppressWarnings("unchecked")
	public static SuccessEventResponse getSuccessEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(SUCCESS_EVENT, log);
        SuccessEventResponse typedResponse = new SuccessEventResponse();
        typedResponse.log = log;
        typedResponse._message = (String) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.trackingNo = (String) eventValues.getNonIndexedValues().get(1).getValue();
        typedResponse._locationData = (List<BigInteger>) ((Array) eventValues.getNonIndexedValues().get(2)).getNativeValueCopy();
        typedResponse._timeStamp = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
        typedResponse._sender = (String) eventValues.getNonIndexedValues().get(4).getValue();
        return typedResponse;
    }

    public Flowable<SuccessEventResponse> successEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getSuccessEventFromLog(log));
    }

    public Flowable<SuccessEventResponse> successEventFlowable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SUCCESS_EVENT));
        return successEventFlowable(filter);
    }

    public RemoteFunctionCall<BigInteger> calculateReputation(String _sender) {
        final Function function = new Function(FUNC_CALCULATEREPUTATION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _sender)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Tuple6<String, BigInteger, List<BigInteger>, BigInteger, String, BigInteger>> checkShipment(
            String trackingNo) {
        final Function function = new Function(FUNC_CHECKSHIPMENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(trackingNo)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Uint8>() {}));
        return new RemoteFunctionCall<Tuple6<String, BigInteger, List<BigInteger>, BigInteger, String, BigInteger>>(function,
                new Callable<Tuple6<String, BigInteger, List<BigInteger>, BigInteger, String, BigInteger>>() {
                    @SuppressWarnings("unchecked")
					@Override
                    public Tuple6<String, BigInteger, List<BigInteger>, BigInteger, String, BigInteger> call(
                            ) throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple6<String, BigInteger, List<BigInteger>, BigInteger, String, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                convertToNative((List<Uint256>) results.get(2).getValue()), 
                                (BigInteger) results.get(3).getValue(), 
                                (String) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue());
                    }
                });
    }

    public RemoteFunctionCall<Tuple2<BigInteger, BigInteger>> checkSuccess(String _sender) {
        final Function function = new Function(FUNC_CHECKSUCCESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _sender)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple2<BigInteger, BigInteger>>(function,
                new Callable<Tuple2<BigInteger, BigInteger>>() {
                    @Override
                    public Tuple2<BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> deleteShipment(String trackingNo) {
        final Function function = new Function(
                FUNC_DELETESHIPMENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(trackingNo)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getBalance(String _account) {
        final Function function = new Function(FUNC_GETBALANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _account)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> receiveShipment(String trackingNo, String _item,
            BigInteger _quantity, List<BigInteger> _locationData) {
        final Function function = new Function(
                FUNC_RECEIVESHIPMENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(trackingNo), 
                new org.web3j.abi.datatypes.Utf8String(_item), 
                new org.web3j.abi.datatypes.generated.Uint256(_quantity), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(_locationData, org.web3j.abi.datatypes.generated.Uint256.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> recoverToken(String _from, BigInteger _amount) {
        final Function function = new Function(
                FUNC_RECOVERTOKEN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _from), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> sendShipment(String trackingNo, String _item,
            BigInteger quantity, List<BigInteger> _locationData) {
        final Function function = new Function(
                FUNC_SENDSHIPMENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(trackingNo), 
                new org.web3j.abi.datatypes.Utf8String(_item), 
                new org.web3j.abi.datatypes.generated.Uint256(quantity), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(_locationData, org.web3j.abi.datatypes.generated.Uint256.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> sendToken(String _from, String _to,
            BigInteger _amount) {
        final Function function = new Function(
                FUNC_SENDTOKEN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _from), 
                new org.web3j.abi.datatypes.Address(160, _to), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setContractParameters(List<BigInteger> _location,
            BigInteger _leadTime, BigInteger _payment) {
        final Function function = new Function(
                FUNC_SETCONTRACTPARAMETERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(_location, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.generated.Uint256(_leadTime), 
                new org.web3j.abi.datatypes.generated.Uint256(_payment)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Tracking load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new Tracking(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Tracking load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Tracking(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Tracking load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new Tracking(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Tracking load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Tracking(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Tracking> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider, BigInteger _initialTokenSupply) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_initialTokenSupply)));
        return deployRemoteCall(Tracking.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    public static RemoteCall<Tracking> deploy(Web3j web3j, TransactionManager transactionManager,
            ContractGasProvider contractGasProvider, BigInteger _initialTokenSupply) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_initialTokenSupply)));
        return deployRemoteCall(Tracking.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Tracking> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit, BigInteger _initialTokenSupply) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_initialTokenSupply)));
        return deployRemoteCall(Tracking.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Tracking> deploy(Web3j web3j, TransactionManager transactionManager,
            BigInteger gasPrice, BigInteger gasLimit, BigInteger _initialTokenSupply) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_initialTokenSupply)));
        return deployRemoteCall(Tracking.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
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

    public static class FailureEventResponse extends BaseEventResponse {
        public String _message;
    }

    public static class PaymentEventResponse extends BaseEventResponse {
        public String _message;

        public String _from;

        public String _to;

        public BigInteger _amount;
    }

    public static class SuccessEventResponse extends BaseEventResponse {
        public String _message;

        public String trackingNo;

        public List<BigInteger> _locationData;

        public BigInteger _timeStamp;

        public String _sender;
    }
}
